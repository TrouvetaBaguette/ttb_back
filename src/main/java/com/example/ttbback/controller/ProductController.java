package com.example.ttbback.controller;


import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Note;
import com.example.ttbback.entity.Product;
import com.example.ttbback.service.ProductService;
import org.hibernate.cfg.PropertyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @GetMapping("/product")
    public  List<Product> getAll(){
        return service.getAll();
    }


    @GetMapping("/product/{name}")
    public Product findProductByLabel(@PathVariable String name) {
        return service.getProductByLabel(name);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@RequestBody Product product, UUID id) {
        service.updateProduct(product,id);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        service.deleteProduct(id);
    }

     @PostMapping(value = "/product/moyenne")
     public Double getMoyenne(@RequestBody Product product) {
        return moyenne.apply(product);
     }
    static Function<Product,Integer> countComment = product -> {
        return Math.toIntExact(product.getComments().stream().count());
    };

     static Function<Product,Double> moyenne = (Product product) -> {
         Double avg = 0.0;
         Optional<Integer> sum = product.getComments().stream()
                 .map(x -> x.getNote().getValue())
                 .reduce(Integer::sum);
         if (sum.isPresent()) {
             avg = sum.get() / countComment.apply(product).doubleValue();
         }
         return avg;
    };
}
