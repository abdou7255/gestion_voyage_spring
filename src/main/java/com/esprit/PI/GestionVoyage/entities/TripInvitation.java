package com.esprit.PI.GestionVoyage.entities;

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
    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn (name = "idEmployee",insertable = false,updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn (name = "idEmployee",insertable = false,updatable = false)
    private Trip trip;

}
