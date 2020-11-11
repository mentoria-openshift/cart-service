package es.thalesalv.sigla.testapi.adapter.data.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    private UUID id;
    private String name;
    private LocalDate releaseDate;
}
