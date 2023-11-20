package com.poc.spring;

import com.poc.spring.domain.request.AuthenticationRequest;
import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.request.RegisterRequest;
import com.poc.spring.service.main.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.poc.spring.model.Role.ADMIN;
import static com.poc.spring.model.Role.MANAGER;

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("\n\n************** STARTING SPRING APPLICATION **************\n\n");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {

			var admin = CreateUserDto.builder()
					.phoneNumber("1234555667")
					.firstName("Admin1")
					.lastName("Admin1")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = CreateUserDto.builder()
					.phoneNumber("1234555666")
					.firstName("Admin2")
					.lastName("Admin2")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());
		};
	}
}
