package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.User;
import com.example.backendawp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<String> getTypes() {
        return null;
    }
}
