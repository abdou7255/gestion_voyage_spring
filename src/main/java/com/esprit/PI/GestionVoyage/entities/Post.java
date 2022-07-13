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
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String content;
    private Date updatedDate;
    private Date createdDate;


    @JsonIgnoreProperties(value="post", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<Comment> comments;

    @JsonIgnoreProperties(value="post", allowSetters=true,allowGetters = false)
    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<React>reacts ;

    @ManyToOne
    @JoinColumn (name = "idForum")
    private Forum forum;
}
