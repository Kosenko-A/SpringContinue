package ru.geekbrains.SpringContinue.dto;

public class ProductDto {

    private String title;
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
