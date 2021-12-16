package com.example.ttbback.controller;


import com.example.ttbback.entity.Bakery;
import com.example.ttbback.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class BakeryController {
    @Autowired
    private BakeryService service;

    public BakeryController(BakeryService service){
        this.service=service;
    }

    @PostMapping("/addBakery")
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

    @PutMapping("/bakery/update")
    public Bakery updateBakery(@RequestBody Bakery bakery) {
        return service.updateBakery(bakery);
    }

    @DeleteMapping("/bakery/delete/{id}")
    public void deleteBakery(@PathVariable UUID id) { service.deleteBakery(id); }
}