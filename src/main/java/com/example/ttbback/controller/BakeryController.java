package com.example.ttbback.controller;


import com.example.ttbback.entity.Bakery;
import com.example.ttbback.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class BakeryController {
    @Autowired
    private BakeryService service;

    public BakeryController(BakeryService service){
        this.service=service;
    }

    @PostMapping("/bakery")
    public Bakery addBakery(@RequestBody Bakery bakery) {
        return service.saveBakery(bakery);
    }

    @GetMapping("/bakeryById/{id}")
    public Bakery findBakeryById(@PathVariable UUID id) {
        return service.getBakeryById(id);
    }

    @GetMapping("/bakery/{name}")
    public Bakery findBakeryByName(@PathVariable String name) {
        return service.getBakeryByName(name);
    }

    @PutMapping("/bakery/{id}")
    public void updateBakery(@RequestBody Bakery bakery, UUID id) {
        service.updateBakery(bakery,id);
    }

    @DeleteMapping("/bakery/{id}")
    public void deleteBakery(@PathVariable UUID id) { service.deleteBakery(id); }
}
