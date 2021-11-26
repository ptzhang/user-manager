package com.bitcloudies.usermanager;

import com.bitcloudies.usermanager.domain.Role;
import com.bitcloudies.usermanager.domain.User;
import com.bitcloudies.usermanager.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "Role_USER"));
			userService.saveRole(new Role(null, "Role_MANAGER"));
			userService.saveRole(new Role(null, "Role_ADMIN"));
			userService.saveRole(new Role(null, "Role_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John D", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John1 D", "john1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John2 D", "john2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John3 D", "john3", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John4 D", "john4", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "Role_USER");
			userService.addRoleToUser("john1", "Role_MANAGER");
			userService.addRoleToUser("john2", "Role_USER");
			userService.addRoleToUser("john3", "Role_ADMIN");
			userService.addRoleToUser("john3", "Role_SUPER_ADMIN");
		};
	}
}
