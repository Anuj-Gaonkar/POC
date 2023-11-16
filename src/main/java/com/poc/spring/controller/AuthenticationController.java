package com.poc.spring.controller;

import com.poc.spring.domain.request.AuthenticationRequest;
import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.domain.response.AuthenticationResponse;
import com.poc.spring.helper.UserHelper;
import com.poc.spring.model.User;
import com.poc.spring.service.main.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody CreateUserDto requestDto){
        return ResponseEntity.ok().body(userService.createUser(requestDto));
    }
}
