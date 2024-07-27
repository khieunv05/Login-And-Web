package com.vti.LoginAndWeb;

import com.vti.LoginAndWeb.Entity.Role;
import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Repository.RoleRepository;
import com.vti.LoginAndWeb.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class LoginAndWebApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoginAndWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setUsername("2351060455");
		user.setPassword(passwordEncoder.encode("2351060455"));
		var adminRole = roleRepository.findByType(Role.Type.ADMIN);
		var userRole = roleRepository.findByType(Role.Type.USER);
		user.setRoles(Set.of(adminRole,userRole));
		userRepository.save(user);
	}
}
