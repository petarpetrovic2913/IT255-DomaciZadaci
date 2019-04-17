package com.example.methotelsserver.services;

import com.example.methotelsserver.payload.JwtLoginSuccessResponse;
import com.example.methotelsserver.payload.LoginRequest;


public interface AuthentificationService {
    JwtLoginSuccessResponse userAuthentification(LoginRequest loginRequest);
}
