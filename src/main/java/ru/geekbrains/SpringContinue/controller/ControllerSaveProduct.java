package ru.geekbrains.SpringContinue.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.SpringContinue.dao.ProductDao;
import ru.geekbrains.SpringContinue.entity.Product;

@RestController
@RequestMapping("/app/products")
public class ControllerSaveProduct {

    ProductDao dao = new ProductDao();

    @GetMapping(value = "/POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(Product product) {
        dao.saveOrUpdate(product);
    }
}
