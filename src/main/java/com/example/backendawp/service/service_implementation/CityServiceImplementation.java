package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.City;
import com.example.backendawp.repository.CityRepository;
import com.example.backendawp.service.CityService;

import java.util.List;
import java.util.Optional;

public class CityServiceImplementation implements CityService {

    private CityRepository cityRepository;

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(Long id, City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
