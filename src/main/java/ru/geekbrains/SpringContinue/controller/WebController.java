package ru.geekbrains.SpringContinue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String index(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/addProduct")
    public String getAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
}
