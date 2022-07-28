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
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_employee")
//    @JoinColumn (name = "idEmployee",insertable = true,updatable = true)
    private Employee employee;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_trip")
//    @JoinColumn (name = "idTrip",insertable = true,updatable = true)
    private Trip trip;

}
