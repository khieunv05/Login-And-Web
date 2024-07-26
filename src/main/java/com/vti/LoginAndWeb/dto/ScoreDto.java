package com.vti.LoginAndWeb.dto;

import com.vti.LoginAndWeb.UserController.ScoreController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class ScoreDto extends RepresentationModel<ScoreDto> {

    private Long id;
    private String subjectName;

    private float score;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ScoreDto withSelfRel(){
        var controller = methodOn(ScoreController.class);
        var score = controller.findById(id);
        var link = linkTo(score).withSelfRel();
        return add(link);
    }
}
