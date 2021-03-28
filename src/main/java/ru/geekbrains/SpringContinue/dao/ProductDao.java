package ru.geekbrains.SpringContinue.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringContinue.entity.Product;
import ru.geekbrains.SpringContinue.repository.ProductRepository;

import javax.persistence.*;
import java.util.List;

@Service
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    public List<Product> findAll() {
        Query query = entityManager.createQuery("select p from Product p");
        List <Product> anotherProduct = null;
        try {
            anotherProduct = (List<Product>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Products weren't found");
        }
        return anotherProduct;
    }

    public Product findById(Long id) {
        Query query = entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        Product anotherProduct;
        try {
            anotherProduct = (Product) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("This person wasn't found");
            anotherProduct = new Product();
        }
        return anotherProduct;
    }

    public Product saveOrUpdate(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Product product = findById(id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

}
