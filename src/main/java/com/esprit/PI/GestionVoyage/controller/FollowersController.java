package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Follower;
import com.esprit.PI.GestionVoyage.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/followers")
@CrossOrigin
@RestController
public class FollowersController {

    @Autowired
    private FollowerService followerService;
    @PostMapping
    public Object create(@RequestBody Follower entity) {

        return followerService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Follower entity) {
        return followerService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return followerService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  followerService.getOne(id);
    }

    @GetMapping
    public List<Follower> getAll() {

        return followerService.getAll();
    }

    @GetMapping("/page")
    public Page<Follower> getAll(Pageable pageable) {
        return  followerService.getAll(pageable);
    }

}
