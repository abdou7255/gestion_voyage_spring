package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CompanyDto implements Serializable {

    private Long idCompany;
    private String email;
    private String password;


    private EmployeeDto employee;


    private ForumDto forum;


    private ActivityDomainDto activityDomain;


    private List<EmployeeInvitaionDto> employeeInvitaions;
}