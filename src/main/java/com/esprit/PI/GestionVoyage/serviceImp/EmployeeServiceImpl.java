package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.EmployeeInvitaion;
import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Object create(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Object update(Long id, Employee entity) {
        try{

            entity.setIdEmployee(id);
            return employeeRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        Page<Employee> zonePage = employeeRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());    }
}
