package ru.geekbrains.SpringContinue.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")

public class Product {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    @ApiModelProperty(value = "Название товара", required = true)
    private String title;

    @Column(name = "price")
    @ApiModelProperty(value = "Цена товара", required = true)
    private int price;


    public Product() {
        UUID.randomUUID();
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    @Transactional
    public String toString() {
        return String.format("id: %s, title: %s, price: %s", id, title, price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
