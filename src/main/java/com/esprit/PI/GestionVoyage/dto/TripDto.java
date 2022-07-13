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
    private String periode;
    private Date tripDate;

    private List<TripInvitationDto> tripInvitations;

    private List<FeedbackDto> feedbacks;

    private List<ProgramDto> programs;

    private TripObjectDto tripObject;
}
