package com.example.backendawp.service;

import com.example.backendawp.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    Ticket save(Ticket ticket);

    Ticket update(Long id, Ticket ticket);

    void deleteById(Long id);

    Optional<Ticket> findById(Long id);

    List<Ticket> findAll();
}
