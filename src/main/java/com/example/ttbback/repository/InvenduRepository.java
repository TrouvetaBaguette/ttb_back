package com.example.ttbback.repository;

import com.example.ttbback.entity.Invendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvenduRepository extends JpaRepository<Invendu,Integer>, CrudRepository<Invendu, Integer> {

    Invendu findByLabel(String name);


    Optional <Invendu> findById(UUID id);

    void deleteById(UUID id);

}
