package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @JsonIgnoreProperties(value="employeeSender", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employeeSender",fetch = FetchType.LAZY)
    private List<Message>messgaeSender;

    @JsonIgnoreProperties(value="employeeReceiver", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employeeReceiver",fetch = FetchType.LAZY)
    private List<Message>messgaeReceiver;

    @JsonIgnore
    @JsonIgnoreProperties(value="employee", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<TripInvitation>tripInvitations;

    @JsonIgnore
    @JsonIgnoreProperties(value="employeeSender", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employeeSender",fetch = FetchType.LAZY)
    private List<Feedback>feedbacksSender;

    @JsonIgnore
    @JsonIgnoreProperties(value="employeeReceiver", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employeeReceiver",fetch = FetchType.LAZY)
    private List<Feedback>feedbacksReceiver;

    @JsonIgnoreProperties(value="employee", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Program>programs;

    @JsonIgnoreProperties(value="employee", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Follower>followers;

    @JsonIgnoreProperties(value="employee", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Comment>comments;

    @JsonIgnoreProperties(value="employee", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<React>reacts;


    @ManyToOne
    @JoinColumn( name="idCompany" )
    private Company company;

    @ManyToOne
    @JoinColumn (name = "idProfession")
    private Profession profession;

}
