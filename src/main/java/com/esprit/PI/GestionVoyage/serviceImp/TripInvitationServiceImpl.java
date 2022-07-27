package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.repository.TripInvitationRepository;
import com.esprit.PI.GestionVoyage.repository.TripRepository;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
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
public class TripInvitationServiceImpl implements TripInvitationService {

    @Autowired
    private TripInvitationRepository tripInvitationRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Object create(TripInvitation entity) {

        return tripInvitationRepository.save(entity);
    }

    @Override
    public Object update(Long id, TripInvitation entity) {
        try{

            entity.setIdTripInvitation(id);
            return tripInvitationRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        tripInvitationRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return tripInvitationRepository.findById(id).get();
    }

    @Override
    public List<TripInvitation> getAll() {
        return tripInvitationRepository.findAll();
    }

    @Override
    public Page<TripInvitation> getAll(Pageable pageable) {
        Page<TripInvitation> zonePage = tripInvitationRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }

    @Override
    public Object createTripInv(Long idEmpl, Long idTrip, TripInvitation tripInv) {
        Employee e = employeeRepository.findById(idEmpl).get();
        Trip t = tripRepository.findById(idTrip).get();
//        e.getTripInvitations().add(tripInv);
//        t.getTripInvitations().add(tripInv);
        tripInv.setEmployee(e);
        tripInv.setTrip(t);

        return tripInvitationRepository.save(tripInv);
    }
}
