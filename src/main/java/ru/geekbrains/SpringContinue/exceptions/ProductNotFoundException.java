package ru.geekbrains.SpringContinue.exceptions;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
