package com.example.service;


import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final UserService userService;

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
