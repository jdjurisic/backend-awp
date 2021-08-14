package com.example.backendawp.service;

import com.example.backendawp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

    Optional<User> findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

}
