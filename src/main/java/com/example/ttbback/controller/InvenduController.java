package com.example.ttbback.controller;

import com.example.ttbback.entity.Invendu;
import com.example.ttbback.entity.Product;
import com.example.ttbback.service.InvenduService;
import com.example.ttbback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class InvenduController {
    @Autowired
    private InvenduService service;


    public InvenduController(InvenduService service) {
        this.service = service;
    }

    @PostMapping("/addInvendu")
    public Invendu addInvendu(@RequestBody Invendu invendu) {
        return service.saveInvendu(invendu);
    }

    @GetMapping("/invendu/{id}")
    public Invendu findInvenduById(@PathVariable UUID id) {
        return service.getInvenduById(id);
    }

    @GetMapping("/invendu/{label}")
    public Invendu getProductByLabel(@PathVariable String name) {
        return service.FindByLabel(name);
    }

    @PutMapping("/invendu/update")
    public Invendu updateInvendu(@RequestBody Invendu invendu) {
        return service.updateInvendu(invendu);
    }

    @DeleteMapping("/invendu/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        service.deleteById(id);
    }

}
