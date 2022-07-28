package com.esprit.PI.GestionVoyage.config;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.EmailSenderService;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee,Employee> {
	@Autowired
	private EmailSenderService emailSenderService;

    @Override
    public Employee process(Employee employee) throws Exception {
    	sendEmail(employee);
        return employee;
    }
    public void sendEmail(Employee employee) {
    	
   
		emailSenderService.sendSimpleMail(employee.getName(),
				"vous devez s'inscrire <a href='www.google.com'> google </a>",
				"invitation d'inscription");
}}
