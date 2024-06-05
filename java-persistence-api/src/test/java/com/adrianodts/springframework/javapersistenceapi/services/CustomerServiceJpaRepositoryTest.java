package com.adrianodts.springframework.javapersistenceapi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adrianodts.springframework.javapersistenceapi.domain.Address;
import com.adrianodts.springframework.javapersistenceapi.domain.Customer;
import com.adrianodts.springframework.javapersistenceapi.domain.User;
import com.adrianodts.springframework.javapersistenceapi.service.CustomerService;

public class CustomerServiceJpaRepositoryTest extends BaseServiceRepository{
    
    private final CustomerService customerService;

    @Autowired
    public CustomerServiceJpaRepositoryTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void shouldGetAllCustomers() {
        var customers = this.customerService.listAll();
        assert customers.size() ==2;
    }

    @Test
    public void shouldSaveCustomerAndUser() {          
        User user1 = new User();
        user1.setEnabled(true);
        user1.setUsername("User 1");
        user1.setVersion(1);
        user1.setPassword("my-pass");
        user1.setEncryptedPassword("super-encrypted-pass");
        
        Customer customer1 = new Customer();
        customer1.setFirstName("Joaquim");
        customer1.setLastName("Silva");
        customer1.setPhoneNumber("1199999-9999");
        customer1.setShippingAddress(new Address());
        customer1.getShippingAddress().setAddressLineOne("Address 1");
        customer1.getShippingAddress().setAddressLineTwo("Address 2");
        customer1.getShippingAddress().setCity("Guarulhos");
        customer1.getShippingAddress().setState("SP");
        customer1.getShippingAddress().setZipCode("01234-567");
        
        customer1.setUser(user1);
        user1.setCustomer(customer1);
    
        Customer expectedCustomer = customerService.saveOrUpdate(customer1);
        User expectedUser = expectedCustomer.getUser();
        assertNotNull(expectedCustomer);
        assertNotNull(expectedUser);
        assertTrue(expectedCustomer == expectedUser.getCustomer());
        assertTrue(expectedUser == expectedCustomer.getUser());
    }

    

}
