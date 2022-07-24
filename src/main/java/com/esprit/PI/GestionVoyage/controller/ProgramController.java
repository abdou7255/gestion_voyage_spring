package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/program")
@CrossOrigin
@RestController
public class ProgramController {

    @Autowired
    private ProgramService programService;
    
    @PostMapping
    public Object create(@RequestBody Program entity) {

        return programService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Program entity) {
        return programService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return programService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  programService.getOne(id);
    }

    @GetMapping("/list")
    public List<Program> getAll() {

        return programService.getAll();
    }

    @GetMapping("/page")
    public Page<Program> getAll(Pageable pageable) {
        return  programService.getAll(pageable);
    }

}
