package com.DigiPet.DigitalPetAPI.pet.application.service;

import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.EditPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.NewPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.PetList;
import com.DigiPet.DigitalPetAPI.pet.domain.ports.input.PetUseCase;
import com.DigiPet.DigitalPetAPI.pet.domain.ports.output.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class petService implements PetUseCase {

    @Autowired
    private PetRepository petRepository;

    @Override
    public int createPet(NewPet pet) {
        return petRepository.createPet(pet);
    }

    @Override
    public List<PetList> getPetsByUserId(Long userId) {
        return petRepository.getPetsByUserId(userId);
    }

    @Override
    public NewPet getPetById(Long petId) {
        return petRepository.getPetById(petId);
    }

    @Override
    public int editPet(EditPet pet) {
        return petRepository.editPet(pet);
    }

    @Override
    public void deceasePet(Long petId, Long userId) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("GMT-4"));
        Timestamp dateNow = Timestamp.from(zonedDateTime.toInstant());
        petRepository.deceasePet(petId, userId, dateNow);
    }


}
