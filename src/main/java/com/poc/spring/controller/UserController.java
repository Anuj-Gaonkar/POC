package com.poc.spring.controller;

import com.poc.spring.domain.request.ChangePasswordRequest;
import com.poc.spring.service.main.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Test");
    }

    /*@PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto requestDto){
        log.info("creating user {}", requestDto);
        User user = userService.createUser(requestDto);
        return ResponseEntity.ok().body(user);
    }*/
}
