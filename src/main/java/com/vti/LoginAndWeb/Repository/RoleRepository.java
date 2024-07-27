package com.vti.LoginAndWeb.Repository;

import com.vti.LoginAndWeb.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByType(Role.Type type);
}
