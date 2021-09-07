package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAvailable;

    @OneToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "enduser_id", referencedColumnName = "id")
    private User user;

}
