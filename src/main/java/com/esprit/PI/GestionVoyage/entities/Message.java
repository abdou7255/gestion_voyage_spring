package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

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

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    private Date dateMessage;

    @ManyToOne
    @JoinColumn (name = "idEmployee",insertable = false,updatable = false)
    private Employee employeeSender;

    @ManyToOne
    @JoinColumn (name = "idEmployee",insertable = false,updatable = false)
    private Employee employeeReceiver;
}
