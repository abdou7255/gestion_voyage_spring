package com.esprit.PI.GestionVoyage.controller;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tripInvitation")
@CrossOrigin
@RestController
public class TripInvitationController {

    @Autowired
    private TripInvitationService tripInvitationService;
    
    @PostMapping
    public Object create(@RequestBody TripInvitation entity) {
        Employee testEmp = new Employee();
        testEmp.setIdEmployee(1l);
        entity.setEmployee(testEmp);
        return tripInvitationService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody TripInvitation entity) {
        return tripInvitationService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return tripInvitationService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  tripInvitationService.getOne(id);
    }

    @GetMapping
    public List<TripInvitation> getAll() {

        return tripInvitationService.getAll();
    }

    @GetMapping("/page")
    public Page<TripInvitation> getAll(Pageable pageable) {
        return  tripInvitationService.getAll(pageable);
    }

}
