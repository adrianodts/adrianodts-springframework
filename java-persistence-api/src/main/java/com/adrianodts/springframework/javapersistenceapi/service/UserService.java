package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;

import com.adrianodts.springframework.javapersistenceapi.domain.User;

public interface UserService {

    List<User> listAll();
    User getById(Long id) throws Exception;
    User saveOrUpdate(User user);
    void delete(Long id) throws Exception;
}
