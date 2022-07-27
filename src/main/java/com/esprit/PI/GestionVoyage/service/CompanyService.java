package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.CompanyDto;
import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;

public interface CompanyService extends BaseService<CompanyDto,Long, Company>{
    Company findCompanyByEmail(String email);
    Company findCompanyByEmailAndPassword(String email, String password);
}
