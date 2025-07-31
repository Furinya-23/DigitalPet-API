package com.DigiPet.DigitalPetAPI.auth.domain.ports.output;

import com.DigiPet.DigitalPetAPI.user.domain.model.User;

public interface AuthRepository {

    User authenticate(String username, String password);
}
