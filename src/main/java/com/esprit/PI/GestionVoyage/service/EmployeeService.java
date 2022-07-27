package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.EmployeeDto;
import com.esprit.PI.GestionVoyage.entities.Employee;

public interface EmployeeService extends BaseService<EmployeeDto,Long, Employee>{
    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByEmailAddressAndPassword(String email,String password);

}
