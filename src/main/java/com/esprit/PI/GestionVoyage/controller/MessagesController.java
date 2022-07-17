package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Message;
import com.esprit.PI.GestionVoyage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/messages")
@CrossOrigin
@RestController
public class MessagesController {

    @Autowired
    private MessageService messageService;
    @PostMapping
    public Object create(@RequestBody Message entity) {

        return messageService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Message entity) {
        return messageService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return messageService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  messageService.getOne(id);
    }

    @GetMapping
    public List<Message> getAll() {

        return messageService.getAll();
    }

    @GetMapping("/page")
    public Page<Message> getAll(Pageable pageable) {
        return  messageService.getAll(pageable);
    }

}
