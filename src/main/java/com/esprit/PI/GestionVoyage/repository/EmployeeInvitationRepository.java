package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.EmployeeInvitaion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInvitationRepository extends JpaRepository<EmployeeInvitaion,Long> {

    @Query(value = "select c from EmployeeInvitaion c where c.email=:email and status='pending'")
    EmployeeInvitaion findEmployeeInvitationByEmail(String email);
}
