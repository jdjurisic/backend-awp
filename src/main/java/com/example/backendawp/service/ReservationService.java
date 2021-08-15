package com.example.backendawp.service;


import com.example.backendawp.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation update(Long id, Reservation reservation);

    void deleteById(Long id);

    Optional<Reservation> findById(Long id);

    List<Reservation> findAll();
}
