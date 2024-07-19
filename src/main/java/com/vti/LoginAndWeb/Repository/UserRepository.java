package com.vti.LoginAndWeb.Repository;

import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
