package es.thalesalv.sigla.testapi.adapter.data.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import es.thalesalv.sigla.testapi.adapter.data.entity.Car;

public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {
}
