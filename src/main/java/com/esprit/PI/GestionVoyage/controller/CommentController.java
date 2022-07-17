package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Comment;
import com.esprit.PI.GestionVoyage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping
    public Object create(@RequestBody Comment entity) {

        return commentService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Comment entity) {
        return commentService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return commentService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  commentService.getOne(id);
    }

    @GetMapping
    public List<Comment> getAll() {

        return commentService.getAll();
    }

    @GetMapping("/page")
    public Page<Comment> getAll(Pageable pageable) {
        return  commentService.getAll(pageable);
    }

}
