package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.TripDto;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Trip;

import java.util.List;

public interface TripService extends BaseService<TripDto,Long, Trip>{
    public List<Employee> getEmployeesByTrip(Long idTrip);
}
