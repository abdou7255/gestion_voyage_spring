package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripInvitationRepository extends JpaRepository<TripInvitation,Long> {
}
