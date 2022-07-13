package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
