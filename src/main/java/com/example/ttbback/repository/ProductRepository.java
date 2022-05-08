package com.example.ttbback.repository;

import com.example.ttbback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, CrudRepository<Product, Integer> {

    Optional <Product> findByLabel(String name);

    Optional<Product> findById(UUID id);

    void deleteById(UUID id);
}
