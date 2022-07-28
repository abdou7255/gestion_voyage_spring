package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.entities.TripInvitation;
import com.esprit.PI.GestionVoyage.entities.TripType;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import com.esprit.PI.GestionVoyage.service.MailService;
import com.esprit.PI.GestionVoyage.service.ProgramService;
import com.esprit.PI.GestionVoyage.service.TripInvitationService;
import com.esprit.PI.GestionVoyage.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/trip")
@CrossOrigin(origins = "*")
@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private ProgramService programService;
    @Autowired
    private TripInvitationService tripInvitationService;
	@Autowired
    private EmployeeService employeeService;
    @Autowired
    private MailService mailService;

    
    @PostMapping
    public Object create(@RequestBody Trip entity) {
        Employee testEmp = new Employee();
        testEmp.setIdEmployee(1l);
        entity.setEmployee(testEmp);
        return tripService.create(entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Trip entity) {
        return tripService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return tripService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  tripService.getOne(id);
    }

    @GetMapping("/list")
    public List<Trip> getAll() {

        return tripService.getAll();
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(@RequestParam("id") Long id)
    {
        return  tripService.getEmployeesByTrip(id);
    }
    @GetMapping("/page")
    public Page<Trip> getAll(Pageable pageable) {
        return  tripService.getAll(pageable);
    }

    @GetMapping("/getFeedbackByTrip/{id}")
    public Number getFeedbacks(@PathVariable Long id) {
        return  tripService.getFeedBackByTrip(id);
    }
  
    @GetMapping("/test")
    public Object test() {
        System.out.println("+++++ Creating 3 employees and a Trip for each");
        Employee e = new Employee();
		employeeService.create(null, e);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = DateFor.parse("01/01/2022");
            d2 = DateFor.parse("03/01/2022");
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        Trip t = new Trip(null, "Tunis", null, 3l, "Marriot Hotel", d1, d2, TripType.Business, null, null, null, e);
        tripService.create(t);

        e = new Employee();
		employeeService.create(null, e);
        DateFor = new SimpleDateFormat("dd/MM/yyyy");
        d1 = new Date();
        d2 = new Date();
        try {
            d1 = DateFor.parse("07/01/2022");
            d2 = DateFor.parse("10/01/2022");
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        t = new Trip(null, "Tunis", null, 4l, "Marriot Hotel", d1, d2, TripType.Business, null, null, null, e);
        tripService.create(t);

        e = new Employee();
		employeeService.create(null, e);
        DateFor = new SimpleDateFormat("dd/MM/yyyy");
        d1 = new Date();
        d2 = new Date();
        try {
            d1 = DateFor.parse("01/01/2022");
            d2 = DateFor.parse("05/01/2022");
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        t = new Trip(null, "Tunis",null, 6l, "Marriot Hotel", d1, d2, TripType.Business, null, null, null, e);
        tripService.create(t);
        mailService.sendSimpleEmail(e.getEmail(), "Trip invitation", "You are invited to a new trip program, checkout your invites.");

        return  "Done";
    }

}
