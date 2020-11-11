package es.thalesalv.sigla.testapi.application.bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.UUID;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import es.thalesalv.sigla.testapi.adapter.data.entity.Car;
import es.thalesalv.sigla.testapi.adapter.data.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class CarApplicationRunner {

    @Bean
    ApplicationRunner init(CarRepository repository) {
        Car ID = new Car(UUID.randomUUID(), "ID.", LocalDate.of(2019, Month.DECEMBER, 1));
        Car ID_CROZZ = new Car(UUID.randomUUID(), "ID. CROZZ", LocalDate.of(2021, Month.MAY, 1));
        Car ID_VIZZION = new Car(UUID.randomUUID(), "ID. VIZZION", LocalDate.of(2021, Month.DECEMBER, 1));
        Car ID_BUZZ = new Car(UUID.randomUUID(), "ID. BUZZ", LocalDate.of(2021, Month.DECEMBER, 1));
        Set<Car> vwConcepts = Set.of(ID, ID_BUZZ, ID_CROZZ, ID_VIZZION);

        return args -> {
            repository.deleteAll().thenMany(Flux.just(vwConcepts).flatMap(repository::saveAll))
                    .thenMany(repository.findAll()).subscribe(car -> log.info("saving " + car.toString()));
        };
    }
}
