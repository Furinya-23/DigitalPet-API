package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.mapper;

import com.DigiPet.DigitalPetAPI.pet.domain.model.Pet;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.entity.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetPersistenceMapper {

    Pet toPet(PetEntity target);
}
