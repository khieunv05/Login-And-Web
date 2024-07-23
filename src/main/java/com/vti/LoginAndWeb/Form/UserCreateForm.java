package com.vti.LoginAndWeb.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank
    @Length(max = 50)
    private String username;
    @NotBlank
    @Length(max = 100)
    private String password;
}
