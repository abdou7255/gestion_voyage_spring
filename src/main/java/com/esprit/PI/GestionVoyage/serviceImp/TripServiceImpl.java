package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.repository.TripRepository;
import com.esprit.PI.GestionVoyage.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Override
    public Object create(Trip entity) {
        entity.setTripDate(new Date());
        return tripRepository.save(entity);
    }

    @Override
    public Object update(Long id, Trip entity) {
        try{

            entity.setIdTrip(id);
            return tripRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        tripRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return tripRepository.findById(id).get();
    }

    @Override
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    @Override
    public Page<Trip> getAll(Pageable pageable) {
        Page<Trip> zonePage = tripRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }

    @Override
    public List<Employee> getEmployeesByTrip(Long idTrip) {
        Trip t= tripRepository.findById(idTrip).get();
        List<Employee> employees=new ArrayList<>();
        for (TripInvitation ti : t.getTripInvitations()){
            employees.add(ti.getEmployee());
        }
        return employees;
    }
}
