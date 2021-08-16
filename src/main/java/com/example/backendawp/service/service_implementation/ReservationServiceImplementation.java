package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.Reservation;
import com.example.backendawp.repository.ReservationRepository;
import com.example.backendawp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImplementation implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
