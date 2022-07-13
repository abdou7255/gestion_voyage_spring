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
public class FollowerDto implements Serializable {

    private Long idFollower;
    private Date followingDate;


    private EmployeeDto employee;


    private ForumDto forum;
}
