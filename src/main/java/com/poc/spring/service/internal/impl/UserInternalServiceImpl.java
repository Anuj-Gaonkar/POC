package com.poc.spring.service.internal.impl;

import com.poc.spring.exception.ModelAlreadyExistsException;
import com.poc.spring.model.User;
import com.poc.spring.repositories.UserRepository;
import com.poc.spring.service.internal.UserInternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInternalServiceImpl implements UserInternalService {

    private final UserRepository userRepository;

    @Override
    public User saveNewUserToDb(User user) {
        if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber()))
            throw new ModelAlreadyExistsException("User not found");
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }
}
