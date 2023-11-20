package com.poc.spring.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String accessToken;
}
