package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedback")
@CrossOrigin
@RestController
public class FeedbackController {

    @Autowired
    private FeedBackService feedBackService;
    @PostMapping
    public Object create(@RequestBody Feedback entity) {

        return feedBackService.create(entity);
    }

    @PostMapping("/sendMail")
    public void sendFeedBackMail() {

        feedBackService.sendSimpleEmail("arfaoui.abdelkader18@gmail.com","testAPIMail","helllo gadour");
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Feedback entity) {
        return feedBackService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return feedBackService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  feedBackService.getOne(id);
    }

    @GetMapping
    public List<Feedback> getAll() {

        return feedBackService.getAll();
    }

    @GetMapping("/page")
    public Page<Feedback> getAll(Pageable pageable) {
        return  feedBackService.getAll(pageable);
    }

}
