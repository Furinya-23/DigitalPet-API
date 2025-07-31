package com.DigiPet.DigitalPetAPI.pet.domain.ports.output;

import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.EditPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.NewPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.PetList;

import java.sql.Timestamp;
import java.util.List;

public interface PetRepository {

    int createPet(NewPet pet);
    List<PetList> getPetsByUserId(Long userId);
    NewPet getPetById(Long petId);
    int editPet(EditPet pet);
    void deceasePet(Long petId, Long userId, Timestamp lastUpdate);
}
