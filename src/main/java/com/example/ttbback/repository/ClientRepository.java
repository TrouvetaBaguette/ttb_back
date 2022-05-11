package com.example.ttbback.repository;

import com.example.ttbback.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>, CrudRepository<Client, Integer> {
    Client findByName(String name);

    Client findById(UUID id);

    Client findByEmail(String email);

    void deleteById(UUID id);
}
