package com.vti.LoginAndWeb.UserController;

import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Service.UserService;
import com.vti.LoginAndWeb.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody UserCreateForm form){
        return userService.create(form);
    }
}
