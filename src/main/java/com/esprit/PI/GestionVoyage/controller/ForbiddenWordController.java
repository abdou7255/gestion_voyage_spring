package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.ForbiddenWord;
import com.esprit.PI.GestionVoyage.service.ForbiddenWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/forbiddenWord")
@CrossOrigin
@RestController
public class ForbiddenWordController {
    @Autowired
    private ForbiddenWordService forbiddenWordService;
    @PostMapping
    public Object create(@RequestBody ForbiddenWord entity) {

        return forbiddenWordService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody ForbiddenWord entity) {
        return forbiddenWordService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return forbiddenWordService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  forbiddenWordService.getOne(id);
    }

    @GetMapping
    public List<ForbiddenWord> getAll() {

        return forbiddenWordService.getAll();
    }

    @GetMapping("/page")
    public Page<ForbiddenWord> getAll(Pageable pageable) {
        return  forbiddenWordService.getAll(pageable);
    }

}
