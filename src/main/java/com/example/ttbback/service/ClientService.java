package com.example.ttbback.service;


import com.example.ttbback.entity.Client;
import com.example.ttbback.repository.ClientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class ClientService {
    private ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public Client getClientById(UUID id) {
        return repository.findById(id);
    }

    public Client getClientByName(String name) {
        return repository.findByName(name);
    }

    public Client getClientByEmail(Client client) {
        return repository.findByEmail(client.getEmail());
    }

    public void deleteClient(UUID id) {
        repository.deleteById(id);
    }

    public Client updateClient(Client client){
        Client existingClient = repository.findById(client.getId());
        existingClient.setName(client.getName());
        existingClient.setAddress(client.getAddress());
        return repository.save(existingClient);
    }
}