package com.example.coursemanager.controllers;

import com.example.coursemanager.dao.UserRepository;
import com.example.coursemanager.exceptions.UserNotFoundException;
import com.example.coursemanager.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return repository.save(user);
    }

    @PutMapping("/user/{id}")
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

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        repository.deleteById(id);
    }

/*    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "name", defaultValue = "bob") Long id) {
        return repository.findById(id);
    }*/
}
