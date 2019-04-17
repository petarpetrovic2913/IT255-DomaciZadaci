package com.example.methotelsserver.services.impl;

import com.example.methotelsserver.model.User;
import com.example.methotelsserver.repositories.UserRepository;
import com.example.methotelsserver.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User addUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public User loadUserById(Long userId) {

        User user = userRepository.getByUserId(userId);

        if(user == null) new UsernameNotFoundException("Customer not found");
        return user;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);

        if(user == null) new UsernameNotFoundException("Customer not found");
        return user;
    }

}
