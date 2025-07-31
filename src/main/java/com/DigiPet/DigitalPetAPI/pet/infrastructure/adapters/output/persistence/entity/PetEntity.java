package com.DigiPet.DigitalPetAPI.pet.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "Pet")
@Data

public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private Short species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private Short gender;

    @Column(name = "birthdate")
    private Timestamp birthDate;

    @Column(name = "status")
    private Short status;

    @Column(name = "registerdate")
    private Timestamp registerDate;

    @Column(name = "lastupdate")
    private Timestamp lastUpdate;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "userlastupdate")
    private Long userLastUpdate;

}
