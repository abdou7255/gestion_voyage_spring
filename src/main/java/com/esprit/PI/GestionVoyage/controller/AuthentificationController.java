package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.dto.auth.AuthentificationRequest;
import com.esprit.PI.GestionVoyage.dto.auth.AuthentificationResponse;
import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationCompanyDetailsService;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationEmployeeDetailsService;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationUserDetailsService;
import com.esprit.PI.GestionVoyage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import java.util.Collections;

@RestController
@RequestMapping("/login/authenticate")
public class AuthentificationController {
    @Autowired
    private ApplicationCompanyDetailsService applicationCompanyDetailsService;
    @Autowired
    private ApplicationEmployeeDetailsService applicationEmployeeDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/employee")
    public ResponseEntity authentificateEmployee(@RequestBody AuthentificationRequest authentificationRequest) {

        Authentication aut = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentificationRequest.getEmail(),
                        authentificationRequest.getPassword()
                )
        );
        if (aut.isAuthenticated()) {
            Employee employee = applicationEmployeeDetailsService.loadUserByUsernameAndPassword(authentificationRequest.getEmail(), authentificationRequest.getPassword());
            if (employee == null) {

                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("Employé inexistant");
            }
            String jwt = jwtUtil.generateToken(new User(employee.getEmail(), employee.getPassword(), Collections.emptyList()));
            return ResponseEntity.ok(AuthentificationResponse.builder().accesToken(jwt).build());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Employé inexistant");
        }
        // return ResponseEntity.ok(AuthentificationResponse.builder().accesToken("access token").build());
    }

    @PostMapping("/company")
    public ResponseEntity authentificateCompany(@RequestBody AuthentificationRequest authentificationRequest) {

        Authentication aut = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentificationRequest.getEmail(),
                        authentificationRequest.getPassword()
                )
        );
        if (aut.isAuthenticated()) {
            Company company = applicationCompanyDetailsService.loadUserByUsernameAndPassword(authentificationRequest.getEmail(), authentificationRequest.getPassword());
            if (company == null) {

                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("Entreprise inexistante");
            }
            String jwt = jwtUtil.generateToken(new User(company.getEmail(), company.getPassword(), Collections.emptyList()));
            return ResponseEntity.ok(AuthentificationResponse.builder().accesToken(jwt).build());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Entreprise inexistante");
        }
        // return ResponseEntity.ok(AuthentificationResponse.builder().accesToken("access token").build());
    }

}
