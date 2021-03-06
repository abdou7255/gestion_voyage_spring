package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private String periode;
    private Date tripDate;

    @JsonIgnore
    @JsonIgnoreProperties(value="trip", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip",fetch = FetchType.LAZY)
    private List<TripInvitation> tripInvitations;
    @JsonIgnore
    @JsonIgnoreProperties(value="trip", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip",fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;

    @JsonIgnoreProperties(value="trip", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "trip",fetch = FetchType.LAZY)
    private List<Program> programs;

    @Enumerated(EnumType.STRING)
    private TripObject tripObject;
}
