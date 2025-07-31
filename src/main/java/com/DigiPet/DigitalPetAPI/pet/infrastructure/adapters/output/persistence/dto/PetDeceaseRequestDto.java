package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.dto;

import lombok.Data;

@Data
public class PetDeceaseRequestDto {
    private Long petId;
    private Long userId;
}