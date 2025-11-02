package com.hokte.SpringSecurityPractice.controller;

import com.hokte.SpringSecurityPractice.model.User;
import com.hokte.SpringSecurityPractice.service.JwtService;
import com.hokte.SpringSecurityPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        // Authenticate the user, check whether the username and password is correct or not for the given user
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
