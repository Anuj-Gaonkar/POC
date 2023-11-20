package com.poc.spring.helper;

import com.poc.spring.domain.request.CreateUserDto;
import com.poc.spring.model.Status;
import com.poc.spring.model.User;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserHelper {

    private UserHelper(){}

    public static User createDtoToEntity(CreateUserDto createUserDto) {
        User user = User.builder()
                .email(createUserDto.getEmail())
                .phoneNumber(createUserDto.getPhoneNumber())
                .otherName(createUserDto.getOtherName())
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .status(Status.INACTIVE.name())
                .role(createUserDto.getRole())
                .isEnabled(false)
                .isUserAccountExpired(true)
                .isUserAccountLocked(true)
                .isUserAccountCredentialsExpired(true)
                .build();
        user.setPublicId(UUID.randomUUID());
        user.setVersion(BigInteger.ZERO);
        user.setCreatedDate(LocalDateTime.now());
        user.setCreatedBy(createUserDto.getFirstName());
        user.setLastModifiedBy(createUserDto.getFirstName());
        user.setLastModifiedDate(LocalDateTime.now());
        return user;
    }
}
