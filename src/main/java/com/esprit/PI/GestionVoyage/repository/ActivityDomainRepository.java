package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDomainRepository extends JpaRepository<ActivityDomain,Long> {
    @Query(value = "select c from ActivityDomain c where c.name=:name")
    ActivityDomain findOneByName(String name);
}
