package com.example.coursemanager;

import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursemanagerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository repository) {
		return args -> {
			repository.save(new User("Bob"));
			repository.save(new User("Alice"));
		};
	}
}
