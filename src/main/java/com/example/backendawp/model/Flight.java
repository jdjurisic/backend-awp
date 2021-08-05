package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private List<Ticket> tickets;

    @OneToMany(mappedBy = "FLIGHT")
    @JoinColumn(name = "city_id")
    private City origin;

    @OneToMany(mappedBy = "FLIGHT")
    @JoinColumn(name = "city_id")
    private City destination;


}
