package ru.geekbrains.SpringContinue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringContinue.entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

}
