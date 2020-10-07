package com.example.coursemanager.controllers;

import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.exceptions.UserNotFoundException;
import com.example.coursemanager.models.Course;
import com.example.coursemanager.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*") //Should only allow specific host not all!
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/{id}/courses")
    public List<Course> getUserCourses(@PathVariable long id) {
        User user = getUserById(id);
        return user.getSubscriptions();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return repository.save(user);
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return repository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        repository.deleteById(id);
    }

/*    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "name", defaultValue = "bob") Long id) {
        return repository.findById(id);
    }*/
}
