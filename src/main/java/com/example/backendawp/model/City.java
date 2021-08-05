package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Unique alphanumeric name is mandatory!")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;

}
