package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@CrossOrigin
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @PostMapping
    public Object create(@RequestBody Company entity) {
        Company c = companyService.findCompanyByEmail(entity.getEmail());
        if(c != null) {
            return new String("cette entreprise existe déja");
        }
        return companyService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Company entity) {
        return companyService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return companyService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  companyService.getOne(id);
    }

    @GetMapping
    public List<Company> getAll() {

        return companyService.getAll();
    }

    @GetMapping("/page")
    public Page<Company> getAll(Pageable pageable) {
        return  companyService.getAll(pageable);
    }

}
