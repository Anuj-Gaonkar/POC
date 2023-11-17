package com.poc.spring.repositories;


import com.poc.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);

    Boolean existsByEmail(String email);

    Boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

    Boolean existsByPhoneNumber(String phoneNumber);
}
