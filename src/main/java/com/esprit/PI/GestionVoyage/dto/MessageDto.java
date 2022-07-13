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

public class MessageDto implements Serializable {


    private Long idMessage;
    private Date dateMessage;


    private EmployeeDto employeeSender;


    private EmployeeDto employeeReceiver;
}
