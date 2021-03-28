package ru.geekbrains.SpringContinue.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.SpringContinue.dao.ProductDao;

@RestController
@RequestMapping("/app/products/delete/{id}")
public class ControllerDeleteProduct {

    ProductDao dao = new ProductDao();

    @GetMapping(value = "/GET", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct() {
        dao.deleteById(2L);
    }
}
