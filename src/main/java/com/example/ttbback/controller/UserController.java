package com.example.ttbback.controller;

import com.example.ttbback.entity.User;
import com.example.ttbback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User findClientById(@PathVariable UUID id) {
        return service.getUserById(id);
    }

    @GetMapping("/user/{name}")
    public User findClientByUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    @PutMapping("/user/update/{id}")
    public void updateClient(@RequestBody User user,UUID id) {
        service.updateUser(user,id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable UUID id) {
        service.deleteById(id);
    }
}

