package com.adrianodts.springframework.javapersistenceapi.bootstrap;

import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.adrianodts.springframework.javapersistenceapi.domain.Address;
import com.adrianodts.springframework.javapersistenceapi.domain.Customer;
import com.adrianodts.springframework.javapersistenceapi.domain.Product;
import com.adrianodts.springframework.javapersistenceapi.domain.User;
import com.adrianodts.springframework.javapersistenceapi.service.CustomerService;
import com.adrianodts.springframework.javapersistenceapi.service.ProductService;
import com.adrianodts.springframework.javapersistenceapi.service.UserService;

@Component
public class SpringJpaRepositoryBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private final CustomerService customerService;
    private ProductService productService;
    private UserService userService;
    
    public SpringJpaRepositoryBootstrap(CustomerService customerService, ProductService productService, UserService userService) {
        this.customerService = customerService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadCustomers();
        loadUsers();
    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Joaquim");
        customer1.setLastName("Silva");
        customer1.setId(1L);
        customer1.setPhoneNumber("1199999-9999");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLineOne("Address 1");
        customer1.getBillingAddress().setAddressLineTwo("Address 2");
        customer1.getBillingAddress().setCity("Guarulhos");
        customer1.getBillingAddress().setState("SP");
        customer1.getBillingAddress().setZipCode("01234-567");        
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Manuel");
        customer2.setLastName("Santos");
        customer2.setId(2L);
        customer2.setPhoneNumber("1188888-88888");
        customer2.setShippingAddress(new Address());
        customer2.getShippingAddress().setAddressLineOne("Address 1");
        customer2.getShippingAddress().setAddressLineTwo("Address 2");
        customer2.getShippingAddress().setCity("Guarulhos");
        customer2.getShippingAddress().setState("SP");
        customer2.getShippingAddress().setZipCode("76543-210");
        customerService.saveOrUpdate(customer2);
    }

    public void loadUsers() {
        User user1 = new User();
        user1.setEnabled(true);
        user1.setUsername("User 1");
        user1.setVersion(1);
        user1.setPassword("my-pass");
        user1.setEncryptedPassword("super-encrypted-pass");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setEnabled(false);
        user2.setUsername("User 2");
        user2.setVersion(2);
        user2.setPassword("my-pass");
        user2.setEncryptedPassword("super-encrypted-pass");
        userService.saveOrUpdate(user2);
    }

    public void loadProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }
    
}
