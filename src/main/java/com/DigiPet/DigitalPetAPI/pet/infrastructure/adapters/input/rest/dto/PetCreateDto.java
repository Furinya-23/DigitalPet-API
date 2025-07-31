package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDto {

    private String name;
    private short species;
    private String breed;
    private short gender;
    private Timestamp birthdate;
    private Long userId;
    private String[] images;

}
