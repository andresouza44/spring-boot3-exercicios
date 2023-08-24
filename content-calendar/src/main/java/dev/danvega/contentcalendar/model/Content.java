package dev.danvega.contentcalendar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public record Content(
    @Id
    Integer id,

    @NotBlank
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dataCreated,
    LocalDateTime dateUpdate,
    String url


    ){

}

