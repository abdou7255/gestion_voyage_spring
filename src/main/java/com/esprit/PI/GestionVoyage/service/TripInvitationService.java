package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.TripInvitationDto;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;

import java.util.List;

public interface TripInvitationService extends BaseService<TripInvitationDto,Long, TripInvitation>{
    Object  createTripInv(Long idEmpl , Long idTrip , TripInvitation tripInv);
    public Number getFeedBackByTripInv(Long idTripInv);
}
