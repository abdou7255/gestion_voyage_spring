package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.*;
import com.esprit.PI.GestionVoyage.repository.CompanyRepository;
import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Object create(Long idCompany ,Employee entity) {
        Company c = companyRepository.findById(idCompany).get();
        entity.setCompany(c);
        entity = employeeRepository.save(entity);
        return entity;
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

    @Override
    public List<Employee> getEmployessByName(String name) {
        List<Employee> employees=getAll();
        List<Employee>listEmplyees=new ArrayList<>();
        for (Employee e : employees){
            if (e.getName().toLowerCase().contains(name.toLowerCase())){
                listEmplyees.add(e);
            }
        }
        return listEmplyees;
    }

    @Override
    public List<Trip> getTripsByEmployee(Long idEmp) {
        Employee e = employeeRepository.findById(idEmp).get();
        List<Trip> trips = new ArrayList<>() ;
        for (Trip t : e.getTrips()){
            trips.add(t);
        }
        return trips;
    }
    
    @Override
    public Employee findEmployeeByEmail(String email) {
        Employee emp = employeeRepository.findEmployeeByEmail(email);
        return emp;
    }

    @Override
    public Employee findEmployeeByEmailAndPassword(String email, String password) {
        Employee emp = employeeRepository.findEmployeeByEmailAndPassword(email,password);
        return emp;
    }
}
