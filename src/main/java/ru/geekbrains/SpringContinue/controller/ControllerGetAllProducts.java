package ru.geekbrains.SpringContinue.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.SpringContinue.dao.ProductDao;
import ru.geekbrains.SpringContinue.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/app/products")
public class ControllerGetAllProducts {

    ProductDao dao = new ProductDao();

    @GetMapping(value = "/GET", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

}
