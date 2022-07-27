package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.dto.auth.AuthentificationRequest;
import com.esprit.PI.GestionVoyage.dto.auth.AuthentificationResponse;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationCompanyDetailsService;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationEmployeeDetailsService;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationUserDetailsService;
import com.esprit.PI.GestionVoyage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
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
    public ResponseEntity<AuthentificationResponse> authentificateEmployee(@RequestBody AuthentificationRequest authentificationRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentificationRequest.getEmail(),
                        authentificationRequest.getPassword()
                )
        );
        final UserDetails userDetails=applicationEmployeeDetailsService.loadUserByUsername(authentificationRequest.getEmail());
        String jwt= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(AuthentificationResponse.builder().accesToken(jwt).build());
        // return ResponseEntity.ok(AuthentificationResponse.builder().accesToken("access token").build());
    }

    @PostMapping("/company")
    public ResponseEntity<AuthentificationResponse> authentificateCompany(@RequestBody AuthentificationRequest authentificationRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentificationRequest.getEmail(),
                        authentificationRequest.getPassword()
                )
        );
        final UserDetails userDetails=applicationCompanyDetailsService.loadUserByUsername(authentificationRequest.getEmail());
        String jwt= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(AuthentificationResponse.builder().accesToken(jwt).build());
        // return ResponseEntity.ok(AuthentificationResponse.builder().accesToken("access token").build());
    }
}
