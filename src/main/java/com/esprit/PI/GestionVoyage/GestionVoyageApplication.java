package com.esprit.PI.GestionVoyage;

import com.esprit.PI.GestionVoyage.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class GestionVoyageApplication {

	@Autowired
	private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(GestionVoyageApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggetMail(){

		emailSenderService.sendSimpleMail("ichrak.dridi@tessi.fr",
				"vous devez s'inscrire <a href='www.google.com'> google </a>",
				"invitation d'inscription");

	}

}
