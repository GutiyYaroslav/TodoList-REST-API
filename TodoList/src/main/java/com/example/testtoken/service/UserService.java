package com.example.testtoken.service;

import com.example.testtoken.model.User;

public interface UserService {
    User getUserByEmail(String email);
}
