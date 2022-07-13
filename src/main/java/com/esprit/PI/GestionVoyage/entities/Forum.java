package com.esprit.PI.GestionVoyage.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idForum;
    private Date createdDate;
    private Date updatedDate;

    @OneToOne
    @JoinColumn( name="idCompany" )
    private Company company;

    @JsonIgnoreProperties(value="forum", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "forum",fetch = FetchType.LAZY)
    private List<Follower> followers;

    @JsonIgnoreProperties(value="forum", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "forum",fetch = FetchType.LAZY)
    private List<Post>posts ;
}
