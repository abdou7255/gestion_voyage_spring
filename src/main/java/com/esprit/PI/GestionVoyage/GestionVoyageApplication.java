package com.esprit.PI.GestionVoyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import com.esprit.PI.GestionVoyage.service.ProgramService;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
import com.esprit.PI.GestionVoyage.service.TripService;

@SpringBootApplication
public class GestionVoyageApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(GestionVoyageApplication.class, args);
	}

}
