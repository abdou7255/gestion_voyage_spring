package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.entities.Profession;
import com.esprit.PI.GestionVoyage.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee/profession")
@CrossOrigin
@RestController
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;
    @PostMapping
    public Object create(@RequestBody Profession entity) {
        Profession profession = professionService.findOneByName(entity.getName());
        if (profession == null) {
            return professionService.create(entity);
        } else {
            return new String("Profession exist !");
        }
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

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Profession entity) {
        Profession profession = professionService.findOneByName(entity.getName());
        if (profession == null) {
            return professionService.update(id, entity);
        } else if(profession.getIdProfession() == id) {
            return professionService.update(id, entity);
        }else {
            return new String("Profession exist !");
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return professionService.delete(id);
    }

}
