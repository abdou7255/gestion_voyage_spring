package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
