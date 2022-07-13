package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Profession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfession;
    private String name;
    private String descrition;


    @JsonIgnoreProperties(value="profession", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "profession",fetch = FetchType.LAZY)
    private List<Employee> employees;
}
