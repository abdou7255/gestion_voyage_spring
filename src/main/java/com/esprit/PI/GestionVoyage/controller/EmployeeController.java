package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Trip;
import com.esprit.PI.GestionVoyage.service.EmployeeService;
import com.esprit.PI.GestionVoyage.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/employee")
@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StatisticService statisticService;
    @PostMapping("/{id}")
    public Object create(@RequestBody Employee entity, @PathVariable Long id) {
        Employee e = employeeService.findEmployeeByEmail(entity.getEmail());
        if(e != null) {
            return new String("cet employé existe déja");
        }
        return employeeService.create(id,entity);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id,@RequestBody Employee entity) {
        return employeeService.update(id,entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id)
    {
        return  employeeService.getOne(id);
    }
    @GetMapping("/getEmployeesByCompany")
    public Number getEmployees(@RequestParam("idComapny") Long idComapny)
    {
        return  statisticService.employeesByCompany(idComapny);
    }

//    @GetMapping
//    public Object employeesByName(@PathParam("name") String name)
//    {
//        return  employeeService.getEmployessByName(name);
//    }


    @GetMapping
    public List<Employee> getAll() {

        return employeeService.getAll();
    }
    @GetMapping("/getTrips")
    public List<Trip> getTrips(@RequestParam("id") Long id) {

        return employeeService.getTripsByEmployee(id);
    }

    @GetMapping("/page")
    public Page<Employee> getAll(Pageable pageable) {
        return  employeeService.getAll(pageable);
    }

}
