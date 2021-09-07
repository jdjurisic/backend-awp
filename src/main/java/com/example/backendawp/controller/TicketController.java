package com.example.backendawp.controller;


import com.example.backendawp.model.Company;
import com.example.backendawp.model.Flight;
import com.example.backendawp.model.Ticket;
import com.example.backendawp.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> save(@Valid @RequestBody Ticket ticket){
        return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/{pageNo}")
    public Page pagintatedTickets(@PathVariable Integer pageNo){
        return ticketService.findAllPaginated(pageNo,10);
    }

    @GetMapping("/oneway/{pageNo}")
    public Page onewayTickets(@PathVariable Integer pageNo){
        return ticketService.onewayPaginated(pageNo,10);
    }

    @GetMapping("/roundtrip/{pageNo}")
    public Page roundtripTickets(@PathVariable Integer pageNo){
        return ticketService.roundtripPaginated(pageNo,10);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable Long id) {
        if(ticketService.findById(id).isPresent()){
            ticketService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}
