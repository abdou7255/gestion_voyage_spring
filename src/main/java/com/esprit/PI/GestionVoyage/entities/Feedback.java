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
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedBack;
    private Date DateFeedBack;
    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn (name = "idEmployeeSender")
    private Employee employeeSender;
    @ManyToOne
    @JoinColumn (name = "idEmployeeReceiver")
    private Employee employeeReceiver;
    @ManyToOne
    @JoinColumn (name = "idTrip")
    private Trip trip;
}
