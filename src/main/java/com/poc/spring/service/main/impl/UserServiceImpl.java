package com.poc.spring.service.main.impl;

import com.poc.spring.config.JwtService;
import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AppResponse;
import com.poc.spring.domain.response.AuthenticationResponse;
import com.poc.spring.domain.response.UserResponse;
import com.poc.spring.helper.UserHelper;
import com.poc.spring.model.User;
import com.poc.spring.service.internal.UserInternalService;
import com.poc.spring.service.main.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserInternalService userInternalService;

    @Override
    public AppResponse<UserResponse> createUser(CreateUserDto userDto) {
        var user = UserHelper.createDtoToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        var newUserToDb = userInternalService.saveNewUserToDb(user);
        return new AppResponse<UserResponse>(HttpStatus.CREATED.value(), "user created successfully",
                UserResponse.builder()
                        .email(newUserToDb.getEmail())
                        .firstName(newUserToDb.getFirstName())
                        .lastName(newUserToDb.getLastName())
                        .build(), null);
    }
}
