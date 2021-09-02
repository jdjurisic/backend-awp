package com.example.backendawp.controller;

import com.example.backendawp.model.Flight;
import com.example.backendawp.model.User;
import com.example.backendawp.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> save(@Valid @RequestBody Flight flight){
        return new ResponseEntity<>(flightService.save(flight), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Flight> findAll(){
        return flightService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> update(@PathVariable Long flightId, @Valid @RequestBody Flight flight){
        if(flightService.findById(flightId) == null) return null;
        return new ResponseEntity<>(flightService.update(flightId,flight), HttpStatus.CREATED);
    }

}
