package com.poc.spring.token;

import com.poc.spring.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
@Entity
public class Token implements Persistable<UUID> {

  @Id
  public UUID id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User user;

  @Override
  public boolean isNew() {
    boolean result = Objects.isNull(id);
    this.id = result ? UUID.randomUUID() : this.id;
    return result;
  }
}
