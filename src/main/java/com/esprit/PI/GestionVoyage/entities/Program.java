package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgram;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String periode;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn (name = "idTrip")
    private Trip trip;

    @ManyToOne
    @JoinColumn (name = "idEmployee")
    private Employee employee;

}
