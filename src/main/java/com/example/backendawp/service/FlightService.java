package com.example.backendawp.service;

import com.example.backendawp.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    Flight save(Flight flight);

    Flight update(Long id, Flight flight);

    void deleteById(Long id);

    Optional<Flight> findById(Long id);

    List<Flight> findAll();


}
