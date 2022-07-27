package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TripInvitation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTripInvitation;
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn (name = "idEmployee",insertable = true,updatable = false)
    private Employee employee;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "idTrip1",insertable = true,updatable = false)
    private Trip trip1; // The trip to join

    @ManyToOne
    @JoinColumn (name = "idTrip2",insertable = true,updatable = false)
    private Trip trip2; // The trip of the user

}
