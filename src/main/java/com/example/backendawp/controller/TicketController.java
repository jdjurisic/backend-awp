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
import java.util.Optional;

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

    @GetMapping("/all/{pageNo}")
    public Page pagintatedTickets(@PathVariable Integer pageNo){
        return ticketService.findAllPaginated(pageNo,5);
    }

    @GetMapping("/oneway/{pageNo}")
    public Page onewayTickets(@PathVariable Integer pageNo){
        return ticketService.onewayPaginated(pageNo,5);
    }

    @GetMapping("/roundtrip/{pageNo}")
    public Page roundtripTickets(@PathVariable Integer pageNo){
        return ticketService.roundtripPaginated(pageNo,5);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable Long id) {
        if(ticketService.findById(id).isPresent()){
            ticketService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id){
        Optional<Ticket> t = ticketService.findById(id);
        if(t.isPresent()){
            return new ResponseEntity<Ticket>(t.get(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{ticketId}")
    public ResponseEntity<Ticket> update(@PathVariable Long ticketId, @Valid @RequestBody Ticket ticket){
        Optional<Ticket> t = ticketService.findById(ticketId);
        if(t.isPresent()){
            Ticket updatedTicket = ticketService.update(ticketId,ticket);
            if(updatedTicket == null){
                return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Ticket>(updatedTicket,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
    }


}
