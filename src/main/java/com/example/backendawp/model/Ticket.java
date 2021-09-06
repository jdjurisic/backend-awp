package com.example.backendawp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    private Boolean oneway;

    private Date departureDate;
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"tickets"})
    private Flight flight;

    private Long count;

}
