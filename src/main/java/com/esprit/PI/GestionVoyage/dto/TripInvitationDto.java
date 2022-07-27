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
public class TripInvitationDto implements Serializable {
    private Long idTripInvitation;
    private String status;

    private EmployeeDto employee;

    private TripDto trip1;
    private TripDto trip2;

}
