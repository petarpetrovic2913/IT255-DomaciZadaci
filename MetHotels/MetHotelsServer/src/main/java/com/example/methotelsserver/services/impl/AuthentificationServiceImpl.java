package com.example.methotelsserver.services.impl;

import com.example.methotelsserver.config.JwtTokenProvider;
import com.example.methotelsserver.payload.JwtLoginSuccessResponse;
import com.example.methotelsserver.payload.LoginRequest;
import com.example.methotelsserver.services.AuthentificationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import static com.example.methotelsserver.config.SecurityConstants.TOKEN_PREFIX;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider tokenProvider;


    public AuthentificationServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }


    public JwtLoginSuccessResponse userAuthentification(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return new JwtLoginSuccessResponse(true , jwt);
    }
}
