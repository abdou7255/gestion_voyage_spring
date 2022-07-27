package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({ "feedbacks", "trips" })
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgram;
    @Column(nullable = false)
    private String description;

    @JsonIgnoreProperties(value="program", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "program",fetch = FetchType.LAZY)
    private List<Trip> trips;

    @JsonIgnoreProperties(value="program", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "program",fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;
}
