package com.DigiPet.DigitalPetAPI.pet.domain.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    private Long id;

    private String name;

    private Short species;

    private String breed;

    private Short gender;

    private Timestamp birthDate;

    private Short status;

    private Timestamp registerDate;

    private Timestamp lastUpdate;

    private Long userId;

    private Long userLastUpdate;

}
