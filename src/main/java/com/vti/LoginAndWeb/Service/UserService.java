package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Form.UserFilterForm;
import com.vti.LoginAndWeb.Form.UserUpdateForm;
import com.vti.LoginAndWeb.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserService {
    UserDto create(UserCreateForm form);

    Page<UserDto> findAll(UserFilterForm form, Pageable pageable);

    UserDto update(UserUpdateForm form, Long id);

    void delete(Long id);

    UserDto findById(Long id);

    void deleteByUsername(String username);
}
