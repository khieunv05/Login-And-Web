package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserCreateForm form);

    List<UserDto> findAll();


}
