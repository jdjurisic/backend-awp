package com.example.backendawp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    @NotNull
    private Boolean oneway;

    @NotNull
    private Date departureDate;

    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"tickets"})
    private Flight flight;

    private Long count;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    @JsonIgnore
    private List<Reservation> reservations;

}
