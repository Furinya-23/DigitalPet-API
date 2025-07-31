package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.repository.interfaces;

import com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.entity.PetEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface IPetJpaRepository extends JpaRepository<PetEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE PetEntity p SET p.status = 0, p.lastUpdate = :deceasedDate, p.userLastUpdate = :userId WHERE p.id = :petId AND p.userId = :userId")
    void deceasePet(@Param("petId") Long petId, @Param("userId") Long userId, @Param("deceasedDate") Timestamp deceasedDate);
}
