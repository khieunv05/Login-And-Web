package com.vti.LoginAndWeb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UserDto {
    private String username;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
