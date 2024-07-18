package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.dto.UserDto;

public interface UserService {
    UserDto create(UserCreateForm form);

}
