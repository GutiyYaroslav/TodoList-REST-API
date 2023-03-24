package com.example.testtoken.service.Impl;

import com.example.testtoken.model.User;
import com.example.testtoken.repository.UserRepository;
import com.example.testtoken.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User getUserByEmail(String email) {
        log.info("log info from method getUserByEmail in userService - email = {}", email);


        User currentUser = null;
        if(userRepository.findByEmail(email).isPresent()){
            currentUser = userRepository.findByEmail(email).get();
        }

        log.info("PART 2: log info from method getUserByEmail in userService - email = {}", email);
        return currentUser;


    }
}
