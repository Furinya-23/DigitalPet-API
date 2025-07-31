package com.DigiPet.DigitalPetAPI.user.domain.model;

import java.sql.Timestamp;

public class User {

    private Long id;
    private Long personId;
    private String username;
    private String passwordHash;
    private Timestamp registerDate;
    private Timestamp lastUpdate;
    private Long userId;
    private Long userLastUpdate;
    private Short status;
    private Short firstLogin;
    private String email;
    private String role;

}
