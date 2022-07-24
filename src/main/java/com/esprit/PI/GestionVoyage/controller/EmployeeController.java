package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/{id}")
    public Object create(@RequestBody Employee entity, @PathVariable Long id) {

        return employeeService.create(id,entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Employee entity) {
        return employeeService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  employeeService.getOne(id);
    }

    @GetMapping
    public List<Employee> getAll() {

        return employeeService.getAll();
    }

    @GetMapping("/page")
    public Page<Employee> getAll(Pageable pageable) {
        return  employeeService.getAll(pageable);
    }

}
