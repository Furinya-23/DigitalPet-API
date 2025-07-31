package com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.output.persistence.repository.interfaces;

import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAuthJpaRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.status = 1")
    Optional<UserEntity> findByUserName(@Param("username") String username);

}
