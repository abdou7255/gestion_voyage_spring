package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.EmployeeDto;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Object           create(Long idCompany,Employee entity);
    Object           update(Long id, Employee entity) ;
    boolean          delete(Long id) ;
    Object           getOne(Long id) ;
    List<Employee> getAll();
    Page<Employee> getAll(Pageable pageable);
}
