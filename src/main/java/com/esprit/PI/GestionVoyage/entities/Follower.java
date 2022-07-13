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
public class Follower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFollower;
    private Date followingDate;

    @ManyToOne
    @JoinColumn (name = "idEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn (name = "idForum")
    private Forum forum;
}
