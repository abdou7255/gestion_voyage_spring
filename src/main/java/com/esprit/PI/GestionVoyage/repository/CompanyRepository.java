package com.esprit.PI.GestionVoyage.repository;

import com.esprit.PI.GestionVoyage.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select c from Company c where c.email=:email")
    Company findCompanyByEmail(String email);

    @Query(value = "select c from Company c where c.email=:email and password=:password")
    Company findCompanyByEmailAndPassword(String email, String password);
}
