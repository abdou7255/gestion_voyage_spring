package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.repository.ProgramRepository;
import com.esprit.PI.GestionVoyage.repository.TripInvitationRepository;
import com.esprit.PI.GestionVoyage.repository.TripRepository;
import com.esprit.PI.GestionVoyage.service.ProgramService;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;
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

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ProgramService programService;

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
    public String accept(Long id) {
        //accept the invitation
        TripInvitation inv = tripInvitationRepository.findById(id).get();
        inv.setStatus("True");
        tripInvitationRepository.save(inv);

        //create or append to a program
        List<Program> programs = programService.getAll();
        boolean added = false;
        for (Program program:programs){
            if(program.getTrips().contains(inv.getTrip1())){
                Trip t2 = inv.getTrip2();
                t2.setProgram(program);
                tripRepository.save(t2);
                program.getTrips().add(t2);
                programRepository.save(program);
                added = true;
            }
        }
        if(!added){
            Trip t1 = inv.getTrip1();
            Trip t2 = inv.getTrip2();
            Program program = new Program();
            program.setDescription("X people are currently on this trip to Y. You can contact each other via chat now.");
            programRepository.save(program);
            t1.setProgram(program);
            t2.setProgram(program);
            tripRepository.save(t1);
            tripRepository.save(t2);
            List<Trip> trips = new ArrayList<Trip>();
            trips.add(t1);
            trips.add(t2);
            program.setTrips(trips);
            programRepository.save(program);
        }

        return "Done";
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
        tripInv.setEmployee(e);
        tripInv.setTrip(t);

        return tripInvitationRepository.save(tripInv);
    }

    @Override
    public Number getFeedBackByTripInv(Long idTripInv) {
        TripInvitation ti = tripInvitationRepository.findById(idTripInv).get();
        return ti.getTrip().getFeedbacks().size();

    }
}
