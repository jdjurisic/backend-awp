package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.Company;
import com.example.backendawp.repository.CompanyRepository;
import com.example.backendawp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Long id, Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public List<Company> findAll() {
        return null;
    }
}
