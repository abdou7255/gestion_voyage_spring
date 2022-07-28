package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.*;
import com.esprit.PI.GestionVoyage.repository.EmployeeInvitationRepository;
import com.esprit.PI.GestionVoyage.service.EmployeeInvitationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class EmployeeInvitationServiceImpl implements EmployeeInvitationService {
    @Autowired
    private EmployeeInvitationRepository employeeInvitationRepository;


    @Override
    public EmployeeInvitaion findEmployeeInvitationByEmail(String email) {
        EmployeeInvitaion ei = employeeInvitationRepository.findEmployeeInvitationByEmail(email);
        return ei;
    }

    @Override
    public Object create(EmployeeInvitaion entity) {
        return employeeInvitationRepository.save(entity);
    }

    @Override
    public Object update(Long id, EmployeeInvitaion entity) {
        try{

            entity.setIdEmployeeInvitation(id);
            return employeeInvitationRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        employeeInvitationRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return employeeInvitationRepository.findById(id).get();
    }

    @Override
    public List<EmployeeInvitaion> getAll() {
        return employeeInvitationRepository.findAll();
    }

    @Override
    public Page<EmployeeInvitaion> getAll(Pageable pageable) {
        Page<EmployeeInvitaion> zonePage = employeeInvitationRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());

    }
}
