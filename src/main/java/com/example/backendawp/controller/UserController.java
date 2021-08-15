package com.example.backendawp.controller;

import com.example.backendawp.model.User;
import com.example.backendawp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@Valid @RequestBody User user){
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }


    @PutMapping ("/{userId}")
    public ResponseEntity<User> update( @PathVariable Long userId, @Valid @RequestBody User user){
        if(service.findById(userId)==null)
            return null;
        return new ResponseEntity<>(service.update(userId, user), HttpStatus.CREATED);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable Long userId){
        service.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> findById( @PathVariable Long userId){
        return new ResponseEntity<Optional<User>>(service.findById(userId), HttpStatus.OK);
    }


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<User> findByUsername( @PathVariable String username){
        return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
    }


    @GetMapping("/all")
    public List<User> findAll(){
        return service.findAll();
    }

}
