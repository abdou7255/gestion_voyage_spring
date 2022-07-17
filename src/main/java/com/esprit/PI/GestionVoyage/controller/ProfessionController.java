package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Profession;
import com.esprit.PI.GestionVoyage.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/profession")
@CrossOrigin
@RestController
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;
    @PostMapping
    public Object create(@RequestBody Profession entity) {

        return professionService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Profession entity) {
        return professionService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return professionService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  professionService.getOne(id);
    }

    @GetMapping
    public List<Profession> getAll() {

        return professionService.getAll();
    }

    @GetMapping("/page")
    public Page<Profession> getAll(Pageable pageable) {
        return  professionService.getAll(pageable);
    }

}
