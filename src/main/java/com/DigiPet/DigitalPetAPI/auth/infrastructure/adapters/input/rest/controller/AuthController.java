package com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.input.rest.controller;


import com.DigiPet.DigitalPetAPI.auth.domain.ports.input.AuthUseCase;
import com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.input.rest.dto.LoginDto;
import com.DigiPet.DigitalPetAPI.auth.infrastructure.adapters.input.rest.mapper.AuthRestMapper;
import com.DigiPet.DigitalPetAPI.shared.security.jwt.JwtService;
import com.DigiPet.DigitalPetAPI.user.domain.model.User;
import com.DigiPet.DigitalPetAPI.user.domain.ports.output.UserRepository;
import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthRestMapper authRestMapper;
    private final JwtService jwtService;
    private final AuthUseCase authUseCase;
    private final UserPersistenceMapper userPersistenceMapper;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto loginDTO){

        User user = authUseCase.authenticate(loginDTO.getUsername(), loginDTO.getPassword());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        var u = userPersistenceMapper.toUserEntity(user);
        String token = jwtService.generateToken(u);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
