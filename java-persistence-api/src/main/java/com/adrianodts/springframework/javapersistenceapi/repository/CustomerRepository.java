package com.adrianodts.springframework.javapersistenceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianodts.springframework.javapersistenceapi.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
