package com.example.coursemanager.controllers;

import com.example.coursemanager.dao.CourseRepository;
import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.models.Course;
import com.example.coursemanager.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public CourseController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/user/{id}/courses")
    public List<Course> getUserCourses(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getSubscriptions();
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }
}
