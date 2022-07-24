package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.repository.FeedBackRepository;
import com.esprit.PI.GestionVoyage.service.FeedBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@Slf4j
public class FeedBackServiceImpl implements FeedBackService {


    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public Object create(Feedback entity) {
        return feedBackRepository.save(entity);
    }

    @Override
    public Object update(Long id, Feedback entity) {
        try{

            entity.setIdFeedBack(id);
            return feedBackRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        feedBackRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public List<Feedback> getAll() {
        return feedBackRepository.findAll();
    }



    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abdelkader.arfaoui@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");


    }

}


