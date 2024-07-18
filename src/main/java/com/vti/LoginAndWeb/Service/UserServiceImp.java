package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Repository.UserRepository;
import com.vti.LoginAndWeb.dto.UserDto;
import com.vti.LoginAndWeb.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }

    @Override
    public List<UserDto> findAll() {
         var users = userRepository.findAll();
         var dtos = new ArrayList<UserDto>();
        for (User user : users) {
            dtos.add(UserMapper.map(user));
        }
        return dtos;
    }
}
