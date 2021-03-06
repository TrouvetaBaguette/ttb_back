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

    public Bakery getBakeryById(UUID id) { return repository.findById(id).orElse(null); }

    public Bakery getBakeryByName(String name) {
        return repository.findByName(name);
    }

    public void deleteBakery(UUID id) {
        Bakery existingbakery = repository.findById(id).orElse(null);
        if (existingbakery !=null) {
            repository.deleteById(existingbakery.getId());
        }
    }

    public void updateBakery(Bakery bakery, UUID id){
        Bakery existingBakery=repository.findById(id).orElse(null);
        if(existingBakery != null) {
            existingBakery.setName(bakery.getName());
            existingBakery.setAddress(bakery.getAddress());
            existingBakery.setPhonenumber(bakery.getPhonenumber());
            repository.save(existingBakery);
        }
    }
}