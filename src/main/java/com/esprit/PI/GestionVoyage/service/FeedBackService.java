package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.FeedbackDto;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeedBackService {
    public void sendSimpleEmail(String toEmail,String subject,String body);
    Object           create(Long idEmp,Long idEmpR,Long idTrip,Feedback entity);
    Object           update(Long id, Feedback entity) ;
    boolean          delete(Long id) ;
    Object           getOne(Long id) ;
    List<Feedback> getAll();
}
