package ru.geekbrains.SpringContinue.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Optional;

@Component

public class Runner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;
    private EntityManager entityManager1;

    @PostConstruct
    public void onInit() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager1 = entityManagerFactory.createEntityManager();
    }

    @Override
    public void run(String... args) throws Exception {
        //Optional <Product> productOptional = productRepository.findById(1L);
        //if (productOptional.isPresent()) {
          //  System.out.println(productOptional.get().toString());
       // }
    }
}
