package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.EmployeeInvitaion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInvitationRepository extends JpaRepository<EmployeeInvitaion,Long> {
}
