package com.vti.LoginAndWeb.mapper;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Form.UserUpdateForm;
import com.vti.LoginAndWeb.dto.UserDto;

public class UserMapper {
    public static User map(UserCreateForm form){
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        return user;
    }
    public static UserDto map(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        return userDto.withSelfRel();
    }
    public static User map(UserUpdateForm form,User user){
        user.setPassword(form.getPassword());
        return user;
    }

}
