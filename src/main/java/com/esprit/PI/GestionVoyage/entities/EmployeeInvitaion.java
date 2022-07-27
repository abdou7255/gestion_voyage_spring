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
public class EmployeeInvitaion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployeeInvitation;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn (name = "idCompany")
    private Company company;
}
