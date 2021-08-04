package com.example.backendawp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //private Company company;

    private Boolean one_way;

    private Date departureDate;
    private Date returnDate;

    //private Flight flight;
    private Long count;

}
