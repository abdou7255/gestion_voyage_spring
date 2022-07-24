package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trip")
@CrossOrigin
@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    
    @PostMapping
    public Object create(@RequestBody Trip entity) {
        Employee testEmp = new Employee();
        testEmp.setIdEmployee(1l);
        entity.setEmployee(testEmp);
        return tripService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Trip entity) {
        return tripService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return tripService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  tripService.getOne(id);
    }

    @GetMapping("/list")
    public List<Trip> getAll() {

        return tripService.getAll();
    }

    @GetMapping("/page")
    public Page<Trip> getAll(Pageable pageable) {
        return  tripService.getAll(pageable);
    }

}
