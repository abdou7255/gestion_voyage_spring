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
public class PostDto implements Serializable {

    private Long idPost;
    private String content;
    private Date updatedDate;
    private Date createdDate;



    private List<CommentDto> comments;


    private List<ReactDto>reacts ;


    private ForumDto forum;
}
