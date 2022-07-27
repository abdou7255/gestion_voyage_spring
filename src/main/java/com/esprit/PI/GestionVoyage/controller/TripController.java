package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/trip")
@CrossOrigin(origins = "*")
@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    @PostMapping
    public Object create(@RequestBody Trip entity) {

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

    @GetMapping
    public List<Trip> getAll() {

        return tripService.getAll();
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(@RequestParam("id") Long id)
    {
        return  tripService.getEmployeesByTrip(id);
    }
    @GetMapping("/page")
    public Page<Trip> getAll(Pageable pageable) {
        return  tripService.getAll(pageable);
    }

    @GetMapping("/getFeedbackByTrip/{id}")
    public Number getFeedbacks(@PathVariable Long id) {
        return  tripService.getFeedBackByTrip(id);
    }

}
