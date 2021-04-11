package ru.geekbrains.SpringContinue.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Configuration
public class Cart {

    HashMap<Long, Optional<Product>> cart = new HashMap<Long, Optional<Product>>();

    @Autowired
    ProductRepository productRepository;

    public void put(Long id) {
        Optional<Product> product = productRepository.findById(id);
        cart.put(id, product);
    }

    public ArrayList<Optional<Product>> get() {
        ArrayList<Optional<Product>> names = new ArrayList<>(cart.values());
        return names;
    }

    public void delete(Long id) {
        cart.remove(id);
    }
}
