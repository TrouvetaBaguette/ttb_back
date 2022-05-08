package com.example.ttbback.service;


import com.example.ttbback.entity.User;
import com.example.ttbback.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUserById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void deleteById(UUID id) {
        User existUser = repository.findById(id).orElse(null);
        if(existUser != null){
            repository.deleteById(existUser.getId());
        }
    }

    public void updateUser(User user, UUID id){
        User existingUser = repository.findById(id).orElse(null);
        existingUser.setAddress(user.getAddress());
        //existingUser.setAllergie(user.getAllergie());
        existingUser.setUsername(user.getUsername());
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_Name(user.getLast_Name());
        repository.save(existingUser);
    }
}