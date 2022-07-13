package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.ForbiddenWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForbiddenWordRepository extends JpaRepository<ForbiddenWord,Long> {
}
