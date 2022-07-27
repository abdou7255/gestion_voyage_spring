package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;

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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @JsonIgnoreProperties(value="activityDomain", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "activityDomain",fetch = FetchType.LAZY)
    private List<Company>companies ;
}
