package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.entities.Employee;

import java.util.List;

public interface StatisticService {
    Number employeesByCompany(Long idComapny);
    List<Employee> listEmployeesByCompany(Long idComapny);
    Integer employeesByTrip(Long idTrip);
    Integer followersByEmployee(Long idEmployee);
    Integer CommentByPost(Long idPost);
    Integer ReactByPost(Long idPost);




}
