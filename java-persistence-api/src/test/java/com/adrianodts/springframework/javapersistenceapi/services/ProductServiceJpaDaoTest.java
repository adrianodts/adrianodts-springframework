package com.adrianodts.springframework.javapersistenceapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.adrianodts.springframework.javapersistenceapi.config.JpaIntegrationConfig;
import com.adrianodts.springframework.javapersistenceapi.domain.Product;
import com.adrianodts.springframework.javapersistenceapi.service.ProductService;

// Sets up spring context 
@SpringBootTest
// Sets up what spring configuration to use, it can by more than one class
@ContextConfiguration(classes = { JpaIntegrationConfig.class })
// Sets up active profile to jpadao h2 database
@ActiveProfiles("jparepository")
public class ProductServiceJpaDaoTest {
    
    private final ProductService productService;

    @Autowired
    public ProductServiceJpaDaoTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void shouldGetAllProducts() {
        var products = this.productService.listAll();
        for (Product product : products) {
            System.out.println(product.getDescription());
        }
        assertEquals(products.size(), 5);
    }
}
