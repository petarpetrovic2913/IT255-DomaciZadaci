package com.example.methotelsserver.controllers;


import com.example.methotelsserver.model.User;
import com.example.methotelsserver.payload.JwtLoginSuccessResponse;
import com.example.methotelsserver.payload.LoginRequest;
import com.example.methotelsserver.services.AuthentificationService;
import com.example.methotelsserver.services.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private UserService userService;
    private AuthentificationService authentificationService;

    public UserController(UserService userService, AuthentificationService authentificationService) {
        this.userService = userService;
        this.authentificationService = authentificationService;
    }

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User register(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.OK)
    public JwtLoginSuccessResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        return authentificationService.userAuthentification(loginRequest);
    }

}
