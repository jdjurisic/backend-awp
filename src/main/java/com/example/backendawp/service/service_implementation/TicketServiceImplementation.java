package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.Ticket;
import com.example.backendawp.repository.TicketRepository;
import com.example.backendawp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImplementation implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Long id, Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
