package com.poc.spring.service.main;

import com.poc.spring.domain.request.AuthenticationRequest;
import com.poc.spring.domain.request.ChangePasswordRequest;
import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AppResponse;
import com.poc.spring.domain.response.AuthenticationResponse;
import com.poc.spring.domain.response.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Principal;

public interface UserService {

    AuthenticationResponse register(CreateUserDto request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
