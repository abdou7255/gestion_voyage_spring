package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Long> {
}
