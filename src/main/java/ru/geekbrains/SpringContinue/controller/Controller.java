package ru.geekbrains.SpringContinue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/app/products")

public class Controller{

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

}
