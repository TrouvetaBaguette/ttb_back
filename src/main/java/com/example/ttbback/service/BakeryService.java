package com.example.ttbback.service;

import com.example.ttbback.entity.Bakery;
import com.example.ttbback.repository.BakeryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class BakeryService {

    private BakeryRepository repository;

    @Autowired
    public BakeryService(BakeryRepository repository) {
        this.repository = repository;
    }

    public Bakery saveBakery(Bakery bakery) {
        return repository.save(bakery);
    }

    public Bakery getBakeryById(UUID id) { return repository.findById(id); }

    public Bakery getBakeryByName(String name) {
        return repository.findByName(name);
    }

    public void deleteBakery(UUID id) {
        repository.deleteById(id);
    }

    public Bakery updateBakery(Bakery bakery){
        Bakery existingBakery=repository.findById(bakery.getId());
        existingBakery.setName(bakery.getName());
        existingBakery.setAddress(bakery.getAddress());
        existingBakery.setPhonenumber(bakery.getPhonenumber());
        existingBakery.setUnsolds(bakery.getProducts());
        return repository.save(existingBakery);
    }
}