package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfessionDto implements Serializable {

    private Long idProfession;
    private String name;
    private String descrition;


    private List<EmployeeDto> employees;
}
