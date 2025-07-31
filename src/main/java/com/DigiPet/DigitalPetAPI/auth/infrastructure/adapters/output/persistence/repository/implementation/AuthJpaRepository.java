package com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.output.persistence.repository.implementation;

import com.DigiPet.DigitalPetAPI.auth.domain.ports.output.AuthRepository;
import com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.output.persistence.repository.interfaces.IAuthJpaRepository;
import com.DigiPet.DigitalPetAPI.user.domain.model.User;
import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.repository.implementation.UserJpaRepository;
import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.repository.interfaces.IUserJpaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthJpaRepository implements AuthRepository {

    @Autowired
    private UserPersistenceMapper userMapper;

    private final IAuthJpaRepository authJpaRepository;

    @Override
    public User authenticate(String username, String password) {
        var getUser = authJpaRepository.findByUserName(username);
        if(getUser.isPresent())
        {
            return userMapper.toUser(getUser.get());
        }
        return null;
    }
}
