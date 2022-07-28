package com.esprit.PI.GestionVoyage.config;


import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.esprit.PI.GestionVoyage.entities.Employee;

public class EmployeeItemWriter implements ItemWriter<Employee> {
   

	@Override
	public void write(List<? extends Employee> items) throws Exception {
		
	}
}
