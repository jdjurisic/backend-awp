package com.example.backendawp.controller;

import com.example.backendawp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }


}
