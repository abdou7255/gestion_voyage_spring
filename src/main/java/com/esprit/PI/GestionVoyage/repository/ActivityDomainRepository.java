package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDomainRepository extends JpaRepository<ActivityDomain,Long> {
}
