package com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;

@Entity
@Table(name = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "personid", nullable = false, unique = true)
    private Long personId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "passwordhash", nullable = false)
    private String passwordHash;

    @Column(name = "registerdate", nullable = false)
    private Timestamp registerDate;

    @Column(name = "lastupdate")
    private Timestamp lastUpdate;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @Column(name = "userlastupdate")
    private Long userLastUpdate;

    @Column(name = "status", nullable = false)
    private Short status;

    @Column(name = "firstLogin", nullable = false)
    private Short firstLogin;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;


    @PrePersist
    protected void onCreate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4"));
        registerDate = new Timestamp(calendar.getTimeInMillis());
        status = 1;
        firstLogin = 1;
    }

    @PreUpdate
    protected void onUpdate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4"));
        lastUpdate = new Timestamp(calendar.getTimeInMillis());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> "ROLE_" + role);
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
