package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.TripInvitationDto;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;

public interface TripInvitationService extends BaseService<TripInvitationDto,Long, TripInvitation>{
    Object           createTripInv(Long idEmpl , Long idTrip , TripInvitation tripInv);
}
