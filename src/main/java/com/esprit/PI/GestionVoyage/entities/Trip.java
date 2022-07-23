package com.esprit.PI.GestionVoyage.entities;

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
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrip;
    private String destination;
    private Long duration;
    private String accommodation;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private TripType tripType;


    @JsonIgnoreProperties(value="trip", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip",fetch = FetchType.LAZY)
    private List<TripInvitation> tripInvitations;

    @ManyToOne
    @JoinColumn (name = "idProgram")
    private Program program;

    @ManyToOne
    @JoinColumn (name = "idEmployee")
    private Employee employee;
}
