package com.example.backendawp.service;

import com.example.backendawp.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    City save(City city);

    City update(Long id, City city);

    void deleteById(Long id);

    Optional<City> findById(Long id);

    List<City> findAll();

}
