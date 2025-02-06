package com.application.rest;

import com.application.rest.entities.RoleEntity;
import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import com.application.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class RestMedycSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMedycSystemApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {

			UserEntity userEntity = UserEntity.builder()
					.email("santiago@mail.com")
					.username("santiago")
					.firstname("fitrsname")
					.lastname("lastname")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(RolType.valueOf(RolType.ADMIN.name()))
							.build()))
					.documentNumber("1003516677")
					.documentType("Cedula de ciudadania")
					.build();

			UserEntity userEntity2 = UserEntity.builder()
					.email("anyi@mail.com")
					.username("anyi")
					.firstname("fitrsname")
					.lastname("lastname")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(RolType.valueOf(RolType.CLIENT.name()))
							.build()))
					.documentNumber("1003516671")
					.documentType("Cedula de ciudadania")
					.build();

			UserEntity userEntity3 = UserEntity.builder()
					.email("andrea@mail.com")
					.username("andrea")
					.firstname("fitrsname")
					.lastname("lastname")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(RolType.valueOf(RolType.PROVIDER.name()))
							.build()))
					.documentNumber("1003513677")
					.documentType("Cedula de ciudadania")
					.build();

			userRepository.save(userEntity);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
		};
	}
}
