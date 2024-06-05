package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adrianodts.springframework.javapersistenceapi.domain.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@Component
@Profile("jpadao")
public class ProductServiceJpaDao implements ProductService {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private final EntityManager em;

    public ProductServiceJpaDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }


    @Override
    public List<Product> listAll() {
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Long id) throws Exception {
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        em.getTransaction().begin();
        Product savedProduct = em.merge(product);
        em.getTransaction().commit();
        return savedProduct;
    }

    @Override
    public void delete(Long id) throws Exception {
        em.getTransaction().begin();
        em.remove(this.getById(id));
        em.getTransaction().commit();
    }

}
