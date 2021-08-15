package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.Flight;
import com.example.backendawp.repository.FlightRepository;
import com.example.backendawp.service.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightServiceImplementation implements FlightService {

    private FlightRepository flightRepository;

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Long id, Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
}
