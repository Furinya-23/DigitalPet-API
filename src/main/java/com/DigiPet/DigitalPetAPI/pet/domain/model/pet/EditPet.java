package com.DigiPet.DigitalPetAPI.pet.domain.model.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EditPet {

    private Long petId;
    private String name;
    private Short species;
    private String breed;
    private Short gender;
    private Timestamp birthdate;
    private Long userId;
    private String[] images;

}
