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
public class FeedbackDto implements Serializable {

    private Long idFeedBack;
    private Date DateFeedBack;
    private String content;


    private EmployeeDto employeeSender;


    private EmployeeDto employeeReceiver;


    private TripDto trip;
}
