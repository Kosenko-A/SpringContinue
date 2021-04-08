package ru.geekbrains.SpringContinue.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @NotBlank
    @ApiModelProperty(value = "Название товара", required = true)
    private String title;

    @NotNull
    @ApiModelProperty(value = "Цена товара", required = true)
    private int price;

    public ProductDto() {

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
