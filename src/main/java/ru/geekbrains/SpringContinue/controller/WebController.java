package ru.geekbrains.SpringContinue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.entity.Person;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.PersonRepository;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public String index(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/indexPersons")
    public String indexPersons(Model model) {
        List<Person> personList = personRepository.findAll();
        model.addAttribute("persons", personRepository);
        return "indexPersons";
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

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/addPerson")
    public String getAddPerson(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/addPerson")
    public String addPerson(Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
