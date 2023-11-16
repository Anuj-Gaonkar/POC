package com.poc.spring.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String otherName;
    private String password;
}
