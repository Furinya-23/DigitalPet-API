package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.repository.implementation;

import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.EditPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.NewPet;
import com.DigiPet.DigitalPetAPI.pet.domain.model.pet.PetList;
import com.DigiPet.DigitalPetAPI.pet.domain.ports.output.PetRepository;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.mapper.PetPersistenceMapper;
import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.repository.interfaces.IPetJpaRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetJpaRepository implements PetRepository {

    private final IPetJpaRepository petJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PetPersistenceMapper petMapper;


    @Override
    public int createPet(NewPet pet) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_insert_pet_with_images");

        query.registerStoredProcedureParameter("p_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_species", Short.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_breed", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_gender", Short.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_birthdate", Timestamp.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_userid", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_images", String[].class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_count", Integer.class, ParameterMode.OUT);

        query.setParameter("p_name", pet.getName());
        query.setParameter("p_species", pet.getSpecies());
        query.setParameter("p_breed", pet.getBreed());
        query.setParameter("p_gender", pet.getGender());
        query.setParameter("p_birthdate", pet.getBirthdate());
        query.setParameter("p_userid", pet.getUserId());
        query.setParameter("p_images", pet.getImages());

        query.execute();

        return (Integer) query.getOutputParameterValue("p_count");

    }

    @Override
    public List<PetList> getPetsByUserId(Long userId) {

        String sql = "SELECT * FROM ufc_get_pets_by_userid(?)";

        Query results = entityManager.createNativeQuery(sql, PetList.class)
                .setParameter(1, userId);

        List<PetList> pets = results.getResultList();

        return pets;
    }

    @Override
    public NewPet getPetById(Long petId){

        String sql = "SELECT * FROM ufc_get_pet_by_id(?)";

        Query result = entityManager.createNativeQuery(sql, NewPet.class)
                .setParameter(1, petId);

        NewPet pet = (NewPet) result.getSingleResult();

        return pet;
    }

    @Override
    public int editPet(EditPet pet){

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_edit_pet_by_pet_id");

        query.registerStoredProcedureParameter("p_petid", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_species", Short.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_breed", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_gender", Short.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_birthdate", Timestamp.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_userid", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_images", String[].class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_count", Integer.class, ParameterMode.OUT);

        query.setParameter("p_petid", pet.getPetId());
        query.setParameter("p_name", pet.getName());
        query.setParameter("p_species", pet.getSpecies());
        query.setParameter("p_breed", pet.getBreed());
        query.setParameter("p_gender", pet.getGender());
        query.setParameter("p_birthdate", pet.getBirthdate());
        query.setParameter("p_userid", pet.getUserId());
        query.setParameter("p_images", pet.getImages());

        query.execute();

        return (Integer) query.getOutputParameterValue("p_count");
    }

    @Override
    @Transactional
    public void deceasePet(Long petId, Long userId, Timestamp lastUpdate) {
        petJpaRepository.deceasePet(petId, userId, lastUpdate);
    }
}
