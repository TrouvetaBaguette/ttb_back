package com.example.ttbback.repository;

import com.example.ttbback.entity.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery,Integer>, CrudRepository<Bakery, Integer> {
    Bakery findByName(String name);

    Bakery findById(UUID id);

    void deleteById(UUID id);
}
