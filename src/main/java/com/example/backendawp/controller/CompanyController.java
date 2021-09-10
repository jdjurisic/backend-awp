package com.example.backendawp.controller;

import com.example.backendawp.model.Company;
import com.example.backendawp.model.Ticket;
import com.example.backendawp.service.CompanyService;
import com.example.backendawp.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompanyController {

    private final CompanyService companyService;
    private final TicketService ticketService;

    public CompanyController(CompanyService companyService, TicketService ticketService) {
        this.companyService = companyService;
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public List<Company> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Optional<Company> cmp = companyService.findById(id);

        if(cmp.isPresent()){
            return new ResponseEntity<Company>(cmp.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> save(@Valid @RequestBody Company company){
        return new ResponseEntity<>(companyService.save(company),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{companyId}")
    public ResponseEntity<?> deleteById(@PathVariable Long companyId){

        // remove tickets, reservations
        List<Ticket> tickets = ticketService.findByCompanyId(companyId);

        for( Ticket t : tickets){
            ticketService.deleteById(t.getId());
        }

        companyService.deleteById(companyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<List<Ticket>> getTicketsForCompany(@PathVariable Long id){
        return new ResponseEntity<>(ticketService.findByCompanyId(id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> edit(@Valid @RequestBody Company company){
        return new ResponseEntity<>(companyService.save(company),HttpStatus.ACCEPTED);
    }

}