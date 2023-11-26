package com.example.restapispring.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getCompanies() {
        return repository.findAll();
    }

    public Company getCompany(Long companyId) {
        return repository.findById(companyId).orElseThrow();
    }

    public Company createCompany(String name) {
        Company company = new Company(name);
        return repository.save(company);
    }

    public void deleteCompany(Long companyId) {
        Company company = repository.findById(companyId).orElseThrow();
        repository.delete(company);
    }

    public Company updateCompany(Long companyId, String name) {
        Company updatedCompany = repository.findById(companyId).orElseThrow();
        updatedCompany.setName(name);

        return repository.save(updatedCompany);
    }

    public Company findById(Long companyId) {
        return repository.findById(companyId).orElseThrow();
    }
}
