package com.poc.spring.domain.request;

import com.poc.spring.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @Email(message = "email must be provided")
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    @NotEmpty(message = "first name must be provided")
    private String firstName;

    @NotEmpty(message = "last name must be provided")
    private String lastName;

    private String otherName;

    @NotEmpty(message = "password must be provided")
    private String password;

    private Role role;
}
