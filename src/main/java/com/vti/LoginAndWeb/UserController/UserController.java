package com.vti.LoginAndWeb.UserController;

import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Form.UserUpdateForm;
import com.vti.LoginAndWeb.Service.UserService;
import com.vti.LoginAndWeb.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody UserCreateForm form){
        return userService.create(form);
    }
    @GetMapping("/api/v1/users")
    public Page<UserDto> findAll(Pageable pageable){
        return userService.findAll(pageable);
    }

    @GetMapping("/api/v1/users/{id}")
    public UserDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PutMapping("/api/v1/users/{id}")
    public  UserDto update(@RequestBody UserUpdateForm form,@PathVariable("id") Long id){
        return userService.update(form,id);
    }
    @DeleteMapping("/api/v1/users/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @DeleteMapping("/api/v1/users/username/{user_name}")
    public void deleteByUsername(@PathVariable("user_name") String username){
         userService.deleteByUsername(username);
    }
}
