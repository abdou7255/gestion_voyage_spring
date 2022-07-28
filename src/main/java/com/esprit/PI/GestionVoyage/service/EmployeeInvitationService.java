package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.CompanyDto;
import com.esprit.PI.GestionVoyage.dto.EmployeeInvitaionDto;
import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.EmployeeInvitaion;

public interface EmployeeInvitationService extends BaseService<EmployeeInvitaionDto,Long, EmployeeInvitaion>{
    EmployeeInvitaion findEmployeeInvitationByEmail(String email);
}
