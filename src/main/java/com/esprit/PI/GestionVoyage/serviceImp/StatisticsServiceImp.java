package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.*;
import com.esprit.PI.GestionVoyage.repository.CompanyRepository;
import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.repository.PostRepository;
import com.esprit.PI.GestionVoyage.repository.TripRepository;
import com.esprit.PI.GestionVoyage.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StatisticsServiceImp implements StatisticService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public Number employeesByCompany(Long idComapny) {
        Company c = companyRepository.findById(idComapny).get();
//        System.out.println(c.getEmployees());
        return c.getEmployees().size();
    }

    @Override
    public List<Employee> listEmployeesByCompany(Long idComapny) {
        Company c = companyRepository.findById(idComapny).get();

        return c.getEmployees();
    }

    @Override
    public Integer employeesByTrip(Long idTrip) {
        Trip t = tripRepository.findById(idTrip).get();
        List<Program> programs= t.getPrograms();
        List<Employee> employees=new ArrayList<>();
        for ( Program p : programs){
            employees.add(p.getEmployee());
        }
        return employees.size();
    }

    @Override
    public Integer followersByEmployee(Long idEmployee) {
        Employee e= employeeRepository.findById(idEmployee).get();
        return e.getFollowers().size();

    }

    @Override
    public Integer CommentByPost(Long idPost) {
        Post p = postRepository.findById(idPost).get();
        return p.getComments().size();
    }

    @Override
    public Integer ReactByPost(Long idPost) {
        Post p = postRepository.findById(idPost).get();
        return p.getReacts().size();
    }

}
