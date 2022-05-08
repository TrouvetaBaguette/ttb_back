package com.example.ttbback.service;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Note;
import com.example.ttbback.entity.Product;
import com.example.ttbback.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Product getProductById(UUID id) { return repository.findById(id).orElse(null); }

    public List<Product> getAll(){ return repository.findAll();}

    public Product getProductByLabel(String name) {
        return repository.findByLabel(name).orElse(null);
    }

    public void deleteProduct(UUID id) {
        Product existArticle = repository.findById(id).orElse(null);
        if(existArticle != null){
            repository.deleteById(existArticle.getId());
        }
    }

    public void updateProduct(Product product, UUID id){
        Product existingProduct= repository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setLabel(product.getLabel());
            existingProduct.setWeight(product.getWeight());
            repository.save(existingProduct);
        }
    }
}