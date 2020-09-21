package com.example.coursemanager.controllers;

import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return repository.findById(id).get();//should return orElse custom exception
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return repository.save(user);
    }

/*    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "name", defaultValue = "bob") Long id) {
        return repository.findById(id);
    }*/
}
