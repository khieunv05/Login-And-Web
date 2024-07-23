package com.vti.LoginAndWeb.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserUpdateForm {
    @NotBlank
    @Length(max = 50)
    private String password;
}
