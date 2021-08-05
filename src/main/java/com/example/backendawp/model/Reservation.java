package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAvailable;

    //private Flight flight;

    //private Ticket ticket;

}
