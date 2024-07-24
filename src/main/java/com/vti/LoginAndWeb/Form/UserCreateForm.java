package com.vti.LoginAndWeb.Form;

import com.vti.LoginAndWeb.validation.UsernameNotExists;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank(message = "{user.id.NotBlank.messages}")
    @Length(max = 50,message = "{user.id.Length.messages}")
    @UsernameNotExists
    private String username;
    @NotBlank
    @Length(max = 100)
    private String password;
}
