package com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.input.rest.dto;

import lombok.Data;

@Data
public class LoginDto {

    private String username;
    private String password;

}
