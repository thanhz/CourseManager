package com.example.coursemanager;

import com.example.coursemanager.dao.CourseRepository;
import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.models.Course;
import com.example.coursemanager.models.Instructor;
import com.example.coursemanager.models.Student;
import com.example.coursemanager.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CoursemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursemanagerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, CourseRepository courseRepository) {
		return args -> {
			//Create the User
			User bob = new Student("Bob");
			User teacher = new Instructor("Bossman");

			//Save the user
			userRepository.save(bob);
			userRepository.save(teacher);

			//Create the course
			Course course = new Course("Java");
			Course course2 = new Course("Python");

			//Save the course
			courseRepository.saveAll(Arrays.asList(course,course2));

			// add course to the user
			bob.getSubscriptions().addAll(Arrays.asList(course,course2));
			teacher.getSubscriptions().add(course);

			//update the user
			userRepository.saveAll(Arrays.asList(bob,teacher));
		};
	}
}
