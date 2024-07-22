package com.vti.LoginAndWeb.Repository;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    @Modifying
    void deleteByUsername(String username);
}
