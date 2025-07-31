package com.DigiPet.DigitalPetAPI.pet.domain.model.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetList {

    private Long petId;
    private String name;
    private Short species;
    private String breed;
    private Short gender;
    private Timestamp birthdate;
    private Timestamp registerDate;
    private String imagePath;

}
