package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adrianodts.springframework.javapersistenceapi.domain.Product;
import com.adrianodts.springframework.javapersistenceapi.repository.ProductRepository;

@Component
@Profile("jparepository")
public class ProductServiceJpaRepository implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceJpaRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        return product.filter(p -> p != null).orElseThrow(() -> new Exception("Product does not exists"));
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) throws Exception {
        productRepository.delete(this.getById(id));
    }


}
