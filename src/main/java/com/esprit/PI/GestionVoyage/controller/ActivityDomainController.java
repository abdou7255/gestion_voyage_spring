package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.service.ActivityDomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/activity")
@CrossOrigin
@RestController
public class ActivityDomainController {

    @Autowired
    private ActivityDomanService activityDomanService;


    @PostMapping
    public Object create(@RequestBody ActivityDomain entity) {

        return activityDomanService.create(entity);
    }

@PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody ActivityDomain entity) {
        return activityDomanService.update(id,entity);
    }

        @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return activityDomanService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  activityDomanService.getOne(id);
    }

    @GetMapping
    public List<ActivityDomain> getAll() {

        return activityDomanService.getAll();
    }

    @GetMapping("/page")
    public Page<ActivityDomain> getAll(Pageable pageable) {
        return  activityDomanService.getAll(pageable);
    }



    }
