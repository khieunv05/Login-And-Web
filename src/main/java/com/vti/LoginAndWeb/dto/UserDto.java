package com.vti.LoginAndWeb.dto;

import com.vti.LoginAndWeb.UserController.UserController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class UserDto extends RepresentationModel<UserDto> {
    private Long id;
    private String username;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDto withSelfRel(){
        var controller = methodOn(UserController.class);
        var user = controller.findById(id);
        var link = linkTo(user).withSelfRel();
        return add(link);
    }
}
