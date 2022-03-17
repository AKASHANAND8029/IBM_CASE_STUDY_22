package com.example.loginregistration.service;

import com.example.loginregistration.model.User;

public interface RegistrationService {
    public User saveUser(User user);
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}
