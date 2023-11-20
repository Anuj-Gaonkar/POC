package com.poc.spring.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {

  @Query(value = "SELECT * FROM Token t INNER JOIN users u ON t.user_id = u.id WHERE u.id = :id AND (t.expired = false OR t.revoked = false)",
          nativeQuery = true)
  List<Token> findAllValidTokenByUser(UUID id);

  Optional<Token> findByToken(String token);
}
