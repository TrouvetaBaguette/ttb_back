package com.example.ttbback.repository;


import com.example.ttbback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, CrudRepository<User, Integer> {
    User findByUsername(String username);

    Optional<User> findById(UUID id);

    void deleteById(UUID id);

    Optional<User> findByEmail(String email);
}
