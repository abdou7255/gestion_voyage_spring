package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.FeedbackDto;
import com.esprit.PI.GestionVoyage.entities.Feedback;

public interface FeedBackService extends BaseService<FeedbackDto,Long, Feedback>{
    public void sendSimpleEmail(String toEmail,String subject,String body);
}
