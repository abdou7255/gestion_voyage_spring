package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<React,Long> {
}
