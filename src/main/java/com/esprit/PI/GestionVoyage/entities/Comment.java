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
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommment;
    private String content;
    private Date updatedDate;
    private Date createdDate;

    @ManyToOne
    @JoinColumn (name = "idEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn (name = "idPost")
    private Post post;
}
