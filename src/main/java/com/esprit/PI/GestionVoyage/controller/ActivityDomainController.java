package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.service.ActivityDomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company/activity")
@CrossOrigin
@RestController
public class ActivityDomainController {

    @Autowired
    private ActivityDomanService activityDomanService;


    @PostMapping
    public Object create(@RequestBody ActivityDomain entity) {
        ActivityDomain activityDomain = activityDomanService.findOneByName(entity.getName());
        if (activityDomain == null) {
            return activityDomanService.create(entity);
        } else {
            return new String("Domaine d'activité existante !");
        }
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id) {
        return activityDomanService.getOne(id);
    }

    @GetMapping
    public List<ActivityDomain> getAll() {
        return activityDomanService.getAll();
    }

    @GetMapping("/page")
    public Page<ActivityDomain> getAll(Pageable pageable) {
        return activityDomanService.getAll(pageable);
    }


    @PutMapping("/{id}")
    public Object update(@PathVariable Long id, @RequestBody ActivityDomain entity) {
        ActivityDomain activityDomain = activityDomanService.findOneByName(entity.getName());
        if (activityDomain == null) {
            return activityDomanService.update(id, entity);
        } else if(activityDomain.getIdActiviityDomain() == id) {
            return activityDomanService.update(id, entity);
        }else {
            return new String("Domaine d'activité existante !");
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return activityDomanService.delete(id);
    }
}
