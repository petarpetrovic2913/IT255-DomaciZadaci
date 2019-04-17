package com.example.methotelsserver.services;

import com.example.methotelsserver.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User loadUserById (Long customerId);
    User addUser(User user);

}
