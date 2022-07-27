package com.esprit.PI.GestionVoyage.service.auth;

import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.CompanyService;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicationCompanyDetailsService implements ApplicationUserDetailsService {

    @Autowired

    private CompanyService companyService;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Company company=companyService.findCompanyByEmailAddress(emailAddress);
        if(company != null){
            return new User(company.getEmailAddress(),company.getPassword(), Collections.emptyList());
        }else {
            throw new UsernameNotFoundException("Entreprise inexistante");
        }
    }

    public Company loadUserByUsernameAndPassword(String emailAddress,String password) throws UsernameNotFoundException {
        return companyService.findCompanyByEmailAddressAndPassword(emailAddress,password);
    }
}
