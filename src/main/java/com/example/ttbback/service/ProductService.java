package com.example.ttbback.service;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Note;
import com.example.ttbback.entity.Product;
import com.example.ttbback.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product getProductById(UUID id) { return repository.findById(id); }

    public Product getProductByLabel(String name) {
        return repository.findByLabel(name);
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product existingProduct= repository.findById(product.getId());
        existingProduct.setLabel(product.getLabel());
        existingProduct.setWeight(product.getWeight());
        return repository.save(existingProduct);
    }
}