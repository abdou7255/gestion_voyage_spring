package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Long> {
}
