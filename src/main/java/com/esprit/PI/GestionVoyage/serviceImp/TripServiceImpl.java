package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.repository.TripRepository;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import com.esprit.PI.GestionVoyage.service.ProgramService;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
import com.esprit.PI.GestionVoyage.service.TripService;
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
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private ProgramService programService;
    @Autowired
    private TripInvitationService tripInvitationService;
	@Autowired
    private EmployeeService employeeService;

    @Override
    public Object create(Trip entity) {
        Object x = tripRepository.save(entity);
        Trip t = entity;
        
        // Matching algorithm
        List<Trip> trips = this.getAll();
        // first we filter the destination, then we filter the date period
        // then we create seperate lists for Hotel, TripType, Profession on employee, in that order
        List<Trip> sHotel = new ArrayList<Trip>();
        List<Trip> sType = new ArrayList<Trip>();
        List<Trip> sProfession = new ArrayList<Trip>();
        for (Trip trip:trips){
            if (!trip.getIdTrip().equals(t.getIdTrip()) && trip.getDestination().equals(t.getDestination()) && trip.getStartDate().before(t.getEndDate()) && t.getStartDate().before(trip.getEndDate())){
                System.out.println("Perfect");
                if(trip.getAccommodation().equals(t.getAccommodation())){
                    sHotel.add(trip);
                }else if(trip.getTripType().equals(t.getTripType())){
                    sType.add(trip);
                }/*else if(trip.getEmployee().getProfession().equals(t.getEmployee().getProfession())){
                    sProfession.add(trip);
                }*/
            }
        }
        // create trip invites
        for (Trip trip:sHotel){
            TripInvitation inv = new TripInvitation(null, "False", t.getEmployee(), trip, t);
            tripInvitationService.create(inv);
        }
        for (Trip trip:sType){
            TripInvitation inv = new TripInvitation(null, "False", t.getEmployee(), trip, t);
            tripInvitationService.create(inv);
        }
        for (Trip trip:sProfession){
            TripInvitation inv = new TripInvitation(null, "False", t.getEmployee(), trip, t);
            tripInvitationService.create(inv);
        }

        return x;
    }

    @Override
    public Object update(Long id, Trip entity) {
        try{
            entity.setIdTrip(id);
            return tripRepository.save(entity);
        }
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
}
