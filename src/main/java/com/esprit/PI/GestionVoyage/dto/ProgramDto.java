package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProgramDto implements Serializable {
    private Long idProgram;
    private String description;
    private String periode;
    private Date startDate;
    private Date endDate;

    private TripDto trip;

    private EmployeeDto employee;

}
