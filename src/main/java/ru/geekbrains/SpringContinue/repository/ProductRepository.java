package ru.geekbrains.SpringContinue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringContinue.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
