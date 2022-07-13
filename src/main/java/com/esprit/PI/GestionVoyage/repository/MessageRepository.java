package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
