package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Post;
import com.esprit.PI.GestionVoyage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping
    public Object create(@RequestBody Post entity) {

        return postService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Post entity) {
        return postService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return postService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  postService.getOne(id);
    }

    @GetMapping
    public List<Post> getAll() {

        return postService.getAll();
    }

    @GetMapping("/page")
    public Page<Post> getAll(Pageable pageable) {
        return  postService.getAll(pageable);
    }

}
