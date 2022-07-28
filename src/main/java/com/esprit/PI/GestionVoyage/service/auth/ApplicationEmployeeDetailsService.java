package com.esprit.PI.GestionVoyage.service.auth;

import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicationEmployeeDetailsService implements ApplicationUserDetailsService {

    @Autowired

    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee emp=employeeService.findEmployeeByEmail(email);
        if(emp != null){
            return new User(emp.getEmail(),emp.getPassword(), Collections.emptyList());
        }else {
            throw new UsernameNotFoundException("Employee inexistante");
        }

    }

    public Employee loadUserByUsernameAndPassword(String email,String password) throws UsernameNotFoundException {
        return employeeService.findEmployeeByEmailAndPassword(email,password);
    }
}
