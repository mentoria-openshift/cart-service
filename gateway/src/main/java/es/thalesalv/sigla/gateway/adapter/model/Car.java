package es.thalesalv.sigla.gateway.adapter.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Car {
    
    private String name;
    private LocalDate releaseDate;
}
