package com.DigiPet.DigitalPetAPI.auth.domain.ports.input;

import com.DigiPet.DigitalPetAPI.user.domain.model.User;

public interface AuthUseCase {

    User authenticate(String username, String password);

}
