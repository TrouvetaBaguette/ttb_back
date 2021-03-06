package com.example.ttbback.controller;

import com.example.ttbback.entity.Client;
import com.example.ttbback.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    public ClientController(ClientService service){
        this.service=service;
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return service.saveClient(client);
    }

    @GetMapping("/ClientById/{id}")
    public Client findClientById(@PathVariable UUID id) {
        return service.getClientById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Client client) {
        Client tmp = service.getClientByEmail(client);

        if(tmp.getPassword().equals(client.getPassword())){
            return new ResponseEntity<>(tmp,HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/client/{name}")
    public Client findClientByName(@PathVariable String name) {
        return service.getClientByName(name);
    }

    @PutMapping("/client/update")
    public Client updateClient(@RequestBody Client client) {
        return service.updateClient(client);
    }

    @DeleteMapping("/client/delete/{id}")
    public void deleteClient(@PathVariable UUID id) {
        service.deleteClient(id);
    }
}

