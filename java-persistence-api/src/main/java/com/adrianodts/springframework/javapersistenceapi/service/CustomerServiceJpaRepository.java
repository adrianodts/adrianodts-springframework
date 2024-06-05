package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adrianodts.springframework.javapersistenceapi.domain.Customer;
import com.adrianodts.springframework.javapersistenceapi.repository.CustomerRepository;

@Component
@Profile("jparepository")
public class CustomerServiceJpaRepository implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceJpaRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.filter(p -> p != null).orElseThrow(() -> new Exception("Customer does not exists"));
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }
    
    @Override
    public void delete(Long id) throws Exception {
        customerRepository.delete(this.getById(id));
    }
    
}
