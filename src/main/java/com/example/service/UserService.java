package com.example.service;

import com.example.database.entity.Company;
import com.example.database.repository.CrudRepository;
import com.example.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
