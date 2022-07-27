package com.esprit.PI.GestionVoyage.dto;

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
public class EmployeeDto implements Serializable {

    private Long idEmployee;
    private String name;
    private String email;
    private String password;


    private List<MessageDto>messgaeSender;


    private List<MessageDto>messgaeReceiver;


    private List<TripInvitationDto>tripInvitations;


    private List<FeedbackDto>feedbacksSender;


    private List<FeedbackDto>feedbacksReceiver;


    private List<ProgramDto>programs;

    private List<FollowerDto>followers;


    private List<CommentDto>comments;


    private List<ReactDto>reacts;


    private CompanyDto company;


    private ProfessionDto profession;

}
