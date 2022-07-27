package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TripDto implements Serializable {
    private Long idTrip;
    private String destination;
    private Long duration;
    private String accommodation;
    private Date startDate;
    private Date endDate;

    private List<TripInvitationDto> tripInvitations;

    private ProgramDto program;

    private TripTypeDto tripType;

    private EmployeeDto employee;
}
