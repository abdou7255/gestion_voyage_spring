package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;


    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToOne
    @JoinColumn( name="idForum" )
    private Forum forum;

    @ManyToOne
    @JoinColumn (name = "idActiviityDomain")
    private ActivityDomain activityDomain;

    @JsonIgnoreProperties(value="company", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<EmployeeInvitaion> employeeInvitaions;
}