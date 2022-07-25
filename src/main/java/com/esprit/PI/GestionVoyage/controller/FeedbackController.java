package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedback")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FeedbackController {

    @Autowired
    private FeedBackService feedBackService;
    @PostMapping
    public Object create(@RequestParam("idSender") Long idEmpSender,@RequestParam("idReceiver") Long idReceiver,@RequestParam("idTrip") Long idTrip,@RequestBody Feedback entity) {
        return feedBackService.create(idEmpSender,idReceiver,idTrip,entity);
    }

    @GetMapping("/sendMail")
    public void sendFeedBackMail(@RequestParam("subject") String subject) {

        feedBackService.sendSimpleEmail("arfaoui.abdelkader18@gmail.com",subject,"You have Feedback Mail ");
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



}
