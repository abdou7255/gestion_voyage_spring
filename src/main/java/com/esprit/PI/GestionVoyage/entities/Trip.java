package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({ "tripInvitations2", "tripInvitations1", "program", "employee" })
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrip;
    @Column(nullable = false)
    private String destination;
    @JsonIgnore
    @JsonIgnoreProperties(value="trip", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip",fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;

    private Long duration;
    private String accommodation;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private TripType tripType;


    @JsonIgnoreProperties(value="trip1", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip1",fetch = FetchType.LAZY)
    private List<TripInvitation> tripInvitations1;

    @JsonIgnoreProperties(value="trip2", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip2",fetch = FetchType.LAZY)
    private List<TripInvitation> tripInvitations2;

    @ManyToOne
    @JoinColumn (name = "idProgram")
    private Program program;

    @ManyToOne
    @JoinColumn (name = "idEmployee")
    @JsonIgnoreProperties(value="trips")
    private Employee employee;
}
