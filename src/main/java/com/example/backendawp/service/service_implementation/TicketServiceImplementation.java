package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.Ticket;
import com.example.backendawp.repository.TicketRepository;
import com.example.backendawp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Ticket> findAllPaginated(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return ticketRepository.findAll(paging);
    }

    @Override
    public Page<Ticket> onewayPaginated(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return ticketRepository.findAllByOneway(paging,true);
    }

    @Override
    public Page<Ticket> roundtripPaginated(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return ticketRepository.findAllByOneway(paging,false);
    }

    @Override
    public List<Ticket> findByCompanyId(Long id) {
        return ticketRepository.findAllByCompanyId(id);
    }

}
