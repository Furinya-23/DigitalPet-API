package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.controller;


import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.EditPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.NewPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.PetList;
import com.DigiPet.DigitalPetAPI.pet.domain.ports.input.PetUseCase;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetCreateDto;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetEditDto;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.dto.PetListDto;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.input.rest.mapper.PetRestMapper;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.dto.PetDeceaseRequestDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetRestMapper petRestMapper;
    private final PetUseCase petService;

    @PostMapping("/createPet")
    public ResponseEntity<?> createPet(@RequestBody PetCreateDto pet) {
        NewPet newPet = petRestMapper.toNewPet(pet);

        if(petService.createPet(newPet) <= 0)
            return new ResponseEntity<>("No se pudo crear la mascota", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/getPetsbyUserId")
    public ResponseEntity<?> getPetsbyUserId(@RequestBody Long userId) {

        List<PetList> pets = petService.getPetsByUserId(userId);
        List<PetListDto>  petList = petRestMapper.toPetListDto(pets);

        if (petList.size() > 0)
            return new ResponseEntity<>(petList, HttpStatus.OK);
        return new ResponseEntity<>("No se pudo encontrar mascotas para el usuario", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/getPetbyId")
    public ResponseEntity<?> getPetById(@RequestBody Long petId) {
        NewPet pet = petService.getPetById(petId);

        if(pet == null)
            return new ResponseEntity<>("No se pudo obtener la informacion de la mascota", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PatchMapping("/editPetbyId")
    public ResponseEntity<?> editPetbyId(@RequestBody PetEditDto pet) {

        EditPet editPet = petRestMapper.toEditPet(pet);

        if(petService.editPet(editPet) <= 0)
            return new ResponseEntity<>("No se pudo actualizar la informacion de la mascota", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/petDeceasebyId")
    public ResponseEntity<?> deceasePet(@RequestBody PetDeceaseRequestDto request) {
        try {
            petService.deceasePet(request.getPetId(), request.getUserId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("No se pudo encontrar la mascota",HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Hubo un error al cambiar el estado de la mascota", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
