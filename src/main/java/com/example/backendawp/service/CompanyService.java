package com.example.backendawp.service;

import com.example.backendawp.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company save(Company company);

    Company update(Long id, Company company);

    void deleteById(Long id);

    Optional<Company> findById(Long id);

    Company findByName(String name);

    List<Company> findAll();
}
