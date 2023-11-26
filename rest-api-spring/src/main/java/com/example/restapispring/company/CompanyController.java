package com.example.restapispring.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> index() {
        return companyService.getCompanies();
    }

    @GetMapping("/{companyId}")
    public Company show(@PathVariable Long companyId) {
        return companyService.getCompany(companyId);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody String name) {
        Company company = companyService.createCompany(name);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(company);
    }

    @PatchMapping("/{companyId}")
    public Company update(@PathVariable Long companyId,@RequestParam(name = "name") String name) {
        return companyService.updateCompany(companyId, name);
    }

    @DeleteMapping("/{companyId}")
    public void delete(@PathVariable(name = "companyId") Long companyId) {
        companyService.deleteCompany(companyId);
    }
}
