package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Form.UserFilterForm;
import com.vti.LoginAndWeb.Form.UserUpdateForm;
import com.vti.LoginAndWeb.Repository.UserRepository;
import com.vti.LoginAndWeb.dto.UserDto;
import com.vti.LoginAndWeb.mapper.UserMapper;
import com.vti.LoginAndWeb.specification.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }

    @Override
    public Page<UserDto> findAll(UserFilterForm form, Pageable pageable) {
        var spec = UserSpecification.spec(form);
        return userRepository.findAll(spec,pageable).map(UserMapper::map);
    }

    @Override
    public UserDto update(UserUpdateForm form, Long id) {
        var user = userRepository.findById(id).get();
        var newUser = UserMapper.map(form,user);
        var savedUser = userRepository.save(newUser);
        return UserMapper.map(savedUser);
    }

    @Override
    public void delete(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public UserDto findById(Long id) {
        var user = userRepository.findById(id).get();
        return UserMapper.map(user);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
