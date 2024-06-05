package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;

import com.adrianodts.springframework.javapersistenceapi.domain.Customer;;

public interface CustomerService {

    List<Customer> listAll();
    Customer getById(Long id) throws Exception;
    Customer saveOrUpdate(Customer customer);
    void delete(Long id) throws Exception;
    
}
