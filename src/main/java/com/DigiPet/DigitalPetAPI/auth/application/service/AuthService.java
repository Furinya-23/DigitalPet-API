package com.DigiPet.DigitalPetAPI.auth.application.service;

import com.DigiPet.DigitalPetAPI.auth.domain.ports.input.AuthUseCase;
import com.DigiPet.DigitalPetAPI.auth.domain.ports.output.AuthRepository;
import com.DigiPet.DigitalPetAPI.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

private final AuthRepository authRepository;

    @Override
    public User authenticate(String username, String password) {
        User user = authRepository.authenticate(username, password);
        if(user == null) {
            return null;
        }
        return user;
    }
}
