package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @ManyToOne
    private City origin;

    @ManyToOne
    private City destination;


}
