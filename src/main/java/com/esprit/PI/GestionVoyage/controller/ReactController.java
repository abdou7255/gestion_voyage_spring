package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.React;
import com.esprit.PI.GestionVoyage.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/react")
@CrossOrigin
@RestController
public class ReactController {
    @Autowired
    private ReactService reactService;
    @PostMapping
    public Object create(@RequestBody React entity) {

        return reactService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody React entity) {
        return reactService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return reactService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  reactService.getOne(id);
    }

    @GetMapping
    public List<React> getAll() {

        return reactService.getAll();
    }

    @GetMapping("/page")
    public Page<React> getAll(Pageable pageable) {
        return  reactService.getAll(pageable);
    }

}
