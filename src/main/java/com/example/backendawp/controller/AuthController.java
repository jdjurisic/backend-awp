package com.example.backendawp.controller;

import com.example.backendawp.model.UserType;
import com.example.backendawp.security.AuthRequest;
import com.example.backendawp.security.MyUserDetails;
import com.example.backendawp.security.MyUserDetailsService;
import com.example.backendawp.util.JwtUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> login(@RequestBody AuthRequest authenticationRequest) {

        try {

            System.out.println(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e){
            e.printStackTrace();
            ResponseEntity.status(401).build();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        final MyUserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        UserType type = userDetails.getUser().getType();
        final String jwt = jwtUtil.generateToken(userDetails);


        // anonymous auth response
        @Data
        class AuthResponse{
            private String jwt;

            public AuthResponse(String jwt){
                this.jwt = jwt;
            }
        }

        return new ResponseEntity<AuthResponse>(new AuthResponse(jwt),HttpStatus.OK);

    }

}
