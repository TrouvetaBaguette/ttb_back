package com.example.ttbback.service;

import com.example.ttbback.entity.Bakery;
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

    public List<Product> getProduct(){ return repository.findAll();}

    public Product getProductById(UUID id) { return repository.findById(id).orElse(null); }

    public Product getProductByLabel(String name) {
        return repository.findByLabel(name);
    }

    public void deleteProduct(UUID id) {
        Product existingproduct = repository.findById(id).orElse(null);
        if (existingproduct !=null) {
            repository.deleteById(existingproduct.getId());
        }
    }

    public void updateProduct(Product product, UUID id){
        Product existingProduct= repository.findById(id).orElse(null);
        if(existingProduct != null) {
            existingProduct.setLabel(product.getLabel());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setWeight(product.getWeight());
            repository.save(existingProduct);
        }
    }
}