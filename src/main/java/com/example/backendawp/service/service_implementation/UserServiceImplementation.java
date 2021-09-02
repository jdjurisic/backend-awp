package com.example.backendawp.service.service_implementation;

import com.example.backendawp.model.User;
import com.example.backendawp.repository.UserRepository;
import com.example.backendawp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user){

        String pass = user.getPassword();
        if(pass.length() < 6 || !pass.matches("[A-Za-z0-9 ]+")){
            throw new RuntimeException("Invalid properties");
        }
        String encryptedPass = passwordEncoder.encode(pass);
        user.setPassword(encryptedPass);
        return userRepository.save(user);

    }

    @Override
    public User update(Long id, User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<String> getTypes() {
        return userRepository.getTypes();
    }

}
