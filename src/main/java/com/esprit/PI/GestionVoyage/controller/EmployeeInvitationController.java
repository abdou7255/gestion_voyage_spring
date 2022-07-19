package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.EmployeeInvitaion;
import com.esprit.PI.GestionVoyage.service.EmployeeInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employeeInv")
@CrossOrigin
@RestController
public class EmployeeInvitationController {

    @Autowired
    private EmployeeInvitationService employeeInvitationService;
    @PostMapping
    public Object create(@RequestBody EmployeeInvitaion entity) {

        return employeeInvitationService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody EmployeeInvitaion entity) {
        return employeeInvitationService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return employeeInvitationService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  employeeInvitationService.getOne(id);
    }

    @GetMapping
    public List<EmployeeInvitaion> getAll() {

        return employeeInvitationService.getAll();
    }

    @GetMapping("/page")
    public Page<EmployeeInvitaion> getAll(Pageable pageable) {
        return  employeeInvitationService.getAll(pageable);
    }

}
