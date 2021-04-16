package ru.geekbrains.SpringContinue.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringContinue.dto.ProductDto;
import ru.geekbrains.SpringContinue.entity.Person;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.exceptions.ProductNotFoundException;
import ru.geekbrains.SpringContinue.mapper.ProductDtoMapper;
import ru.geekbrains.SpringContinue.repository.PersonRepository;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/product")
public class ControllerRest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    @ApiOperation("Вывести список товаров")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Вывести товар по id")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("" +
                String.format("Не найден товар с идентификатром %s", id)));
    }

    @PostMapping
    @ApiOperation("Сохранить товар")
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping
    @ApiOperation("Обновить информацию о товаре")
    public void updateProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Удалить товар по id")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping("post")
    @ApiOperation("Сохранить товар")
    public Product saveProduct(@RequestBody @Valid ProductDto productDto) {
       /* Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());*/

        Product product = ProductDtoMapper.MAPPER.toProduct(productDto);
        productRepository.save(product);
        return product;
    }

}
