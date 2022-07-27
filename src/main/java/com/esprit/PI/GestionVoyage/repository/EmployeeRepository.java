package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select c from Employee c where c.email=:email")
    Employee findEmployeeByEmail(String email);
    @Query(value = "select c from Employee c where c.email=:email and password=:password")
    Employee findEmployeeByEmailAddressAndPassword(String email,String password);


}
