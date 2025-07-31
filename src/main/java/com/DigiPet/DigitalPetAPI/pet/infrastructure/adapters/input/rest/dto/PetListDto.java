package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetListDto {
    private Long petId;
    private String name;
    private Short species;
    private String breed;
    private Short gender;
    private Timestamp birthdate;
    private Timestamp registerDate;
    private String imagePath;
}
