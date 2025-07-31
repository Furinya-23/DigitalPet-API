package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.mapper;

import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.EditPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.NewPet;

import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.PetList;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetCreateDto;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetEditDto;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetListDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetRestMapper {

    NewPet toNewPet(PetCreateDto target);
    PetCreateDto toPetCreateDto(NewPet target);

    List<PetList> toPetList(List<PetListDto> target);
    List<PetListDto> toPetListDto(List<PetList> target);

    EditPet toEditPet(PetEditDto target);
    PetEditDto toPetEditDto(PetEditDto target);
}
