package ru.geekbrains.SpringContinue.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.entity.Cart;
import ru.geekbrains.SpringContinue.entity.Product;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @Autowired
    Cart cart = new Cart();

    @PostMapping("{id}")
    @ApiOperation("Добавить товар в корзину")
    public String addProductInCart(@PathVariable Long id) {
        cart.put(id);
        return "redirect:/";
    }

    @GetMapping
    @ApiOperation("Просмотр товаров в корзине")
    public ArrayList<Optional<Product>> showCart() {
       return cart.get();
    }

}
