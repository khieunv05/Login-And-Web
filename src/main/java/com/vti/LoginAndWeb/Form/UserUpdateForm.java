package com.vti.LoginAndWeb.Form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserUpdateForm {
    private String username;
    private String password;
    private LocalDateTime createdAt;
}
