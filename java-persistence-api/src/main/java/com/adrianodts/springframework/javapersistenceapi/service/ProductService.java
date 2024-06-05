package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;

import com.adrianodts.springframework.javapersistenceapi.domain.Product;;

public interface ProductService {

    List<Product> listAll();
    Product getById(Long id) throws Exception;
    Product saveOrUpdate(Product product);
    void delete(Long id) throws Exception;
    
}
