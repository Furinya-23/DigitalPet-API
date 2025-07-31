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
public class NewPet {

    private String name;
    private short species;
    private String breed;
    private short gender;
    private Timestamp birthdate;
    private Long userId;
    private String[] images;

}
