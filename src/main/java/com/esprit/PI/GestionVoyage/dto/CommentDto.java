package com.esprit.PI.GestionVoyage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommentDto implements Serializable {

    private Long idCommment;
    private String content;
    private Date updatedDate;
    private Date createdDate;


    private EmployeeDto employee;


    private PostDto post;
}
