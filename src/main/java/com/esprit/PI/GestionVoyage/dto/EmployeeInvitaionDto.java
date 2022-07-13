package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeInvitaionDto implements Serializable {

    private Long idEmployeeInvitation;
    private String status;
    private String email;


    private CompanyDto company;
}
