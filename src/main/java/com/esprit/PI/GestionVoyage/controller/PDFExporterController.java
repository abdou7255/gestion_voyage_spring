package com.esprit.PI.GestionVoyage.controller;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.service.StatisticService;
import com.esprit.PI.GestionVoyage.serviceImp.EmployeesPDFExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/pdfListEmployee")
@CrossOrigin
@RestController
public class PDFExporterController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/{id}")
    public void exportToPDF(HttpServletResponse response, @PathVariable Long id) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Employee> listEmployee =statisticService.listEmployeesByCompany(id) ;

        EmployeesPDFExporter exporter = new EmployeesPDFExporter(listEmployee);
        exporter.export(response);

    }
}
