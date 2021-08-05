package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType type;

    //private List<Reservation> reservations;

}
