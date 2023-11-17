package com.poc.spring.service.main;

import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AppResponse;
import com.poc.spring.domain.response.UserResponse;

public interface UserService {

    AppResponse<UserResponse> createUser(CreateUserDto userDto);
}
