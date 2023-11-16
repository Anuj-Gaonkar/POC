package com.poc.spring.service.main;

import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AuthenticationResponse;
import com.poc.spring.model.User;

public interface UserService {

    AuthenticationResponse createUser(CreateUserDto userDto);
}
