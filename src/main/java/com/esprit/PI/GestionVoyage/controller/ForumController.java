package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Forum;
import com.esprit.PI.GestionVoyage.service.ForumServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/forum")
@CrossOrigin
@RestController
public class ForumController {

    @Autowired
    private ForumServicee forumServicee;
    @PostMapping
    public Object create(@RequestBody Forum entity) {

        return forumServicee.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Forum entity) {
        return forumServicee.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return forumServicee.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  forumServicee.getOne(id);
    }

    @GetMapping
    public List<Forum> getAll() {

        return forumServicee.getAll();
    }

    @GetMapping("/page")
    public Page<Forum> getAll(Pageable pageable) {
        return  forumServicee.getAll(pageable);
    }

}
