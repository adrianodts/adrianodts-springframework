package com.adrianodts.springframework.javapersistenceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianodts.springframework.javapersistenceapi.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
