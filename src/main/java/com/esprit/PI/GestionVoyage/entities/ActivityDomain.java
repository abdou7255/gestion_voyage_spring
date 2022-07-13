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
public class ActivityDomain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActiviityDomain;
    private String name;
    private String description;


    @JsonIgnoreProperties(value="activityDomain", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "activityDomain",fetch = FetchType.LAZY)
    private List<Company>companies ;
}
