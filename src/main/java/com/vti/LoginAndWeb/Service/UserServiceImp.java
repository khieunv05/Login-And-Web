package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.Role;
import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserCreateForm;
import com.vti.LoginAndWeb.Form.UserFilterForm;
import com.vti.LoginAndWeb.Form.UserUpdateForm;
import com.vti.LoginAndWeb.Repository.RoleRepository;
import com.vti.LoginAndWeb.Repository.UserRepository;
import com.vti.LoginAndWeb.dto.UserDto;
import com.vti.LoginAndWeb.mapper.UserMapper;
import com.vti.LoginAndWeb.specification.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateForm form) {
        User user = UserMapper.map(form);
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var role = roleRepository.findByType(Role.Type.USER);
        user.setRoles(Set.of(role));
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        var authorities = new ArrayList<GrantedAuthority>();
        for (var role : user.getRoles()) {
            var authority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(authority);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(), authorities
        );
    }
}
