package com.poc.spring.service.main.impl;

import com.poc.spring.config.JwtService;
import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AuthenticationResponse;
import com.poc.spring.helper.UserHelper;
import com.poc.spring.model.User;
import com.poc.spring.service.internal.UserInternalService;
import com.poc.spring.service.main.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final JwtService jwtService;

    private final UserInternalService userInternalService;

    @Override
    public AuthenticationResponse createUser(CreateUserDto userDto) {
        var user = UserHelper.createDtoToEntity(userDto);
        var newUserToDb = userInternalService.saveNewUserToDb(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
