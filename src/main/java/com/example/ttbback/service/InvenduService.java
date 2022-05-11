package com.example.ttbback.service;


import com.example.ttbback.entity.Invendu;
import com.example.ttbback.repository.InvenduRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class InvenduService {
    private InvenduRepository repository;

    @Autowired
    public InvenduService(InvenduRepository repository) {
        this.repository = repository;
    }

    public Invendu saveInvendu(Invendu invendu) {
        return repository.save(invendu);
    }

    public Invendu getInvenduById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Invendu FindByLabel(String label) {
        return repository.findByLabel(label);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public void updateInvendu(Invendu invendu, UUID id){
        Invendu existingInvendu = repository.findById(id).orElse(null);
        if(existingInvendu !=null) {
            existingInvendu.setPrix(existingInvendu.getPrix());
            existingInvendu.setQuantité(existingInvendu.getQuantité());
            existingInvendu.setReservable(existingInvendu.isReservable());
            repository.save(existingInvendu);
        }
    }
}
