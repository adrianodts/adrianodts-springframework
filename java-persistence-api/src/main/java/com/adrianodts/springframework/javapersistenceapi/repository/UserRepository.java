package com.adrianodts.springframework.javapersistenceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianodts.springframework.javapersistenceapi.domain.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
