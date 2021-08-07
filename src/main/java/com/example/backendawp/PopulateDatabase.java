package com.example.backendawp;

import com.example.backendawp.model.User;
import com.example.backendawp.model.UserType;
import com.example.backendawp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PopulateDatabase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // create users
//        User user1 = new User();
//        user1.setUsername("Korisnik");
//        user1.setPassword("Sifra123");
//        user1.setType(UserType.USER);
//
//        User user2 = new User();
//        user2.setUsername("Admin");
//        user2.setPassword("Sifra123");
//        user2.setType(UserType.ADMIN);
//
//        userRepository.save(user1);
//        userRepository.save(user2);


    }
}
