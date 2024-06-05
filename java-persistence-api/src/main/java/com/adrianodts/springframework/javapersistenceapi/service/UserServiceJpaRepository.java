package com.adrianodts.springframework.javapersistenceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adrianodts.springframework.javapersistenceapi.domain.User;
import com.adrianodts.springframework.javapersistenceapi.repository.UserRepository;

@Component
@Profile("jparepository")
public class UserServiceJpaRepository implements UserService {

    private UserRepository userRepository;

    public UserServiceJpaRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) throws Exception {
        Optional<User> User = userRepository.findById(id);
        return User.filter(p -> p != null).orElseThrow(() -> new Exception("User does not exists"));
    }

    @Override
    public User saveOrUpdate(User User) {
        return userRepository.save(User);
    }
    
    @Override
    public void delete(Long id) throws Exception {
        userRepository.delete(this.getById(id));
    }
    
}
