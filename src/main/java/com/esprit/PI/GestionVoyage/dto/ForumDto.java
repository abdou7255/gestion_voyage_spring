package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ForumDto implements Serializable {

    private Long idForum;
    private Date createdDate;
    private Date updatedDate;


    private CompanyDto company;


    private List<FollowerDto> followers;


    private List<PostDto>posts ;
}
