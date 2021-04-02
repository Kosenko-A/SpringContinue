package ru.geekbrains.SpringContinue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.dto.ProductDto;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/product")
public class ControllerRest {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        return product;
    }

}
