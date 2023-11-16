package com.poc.spring.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class User extends BaseEntity implements UserDetails {
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String otherName;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleName role;
    private String status;
    private Boolean isEnabled;
    private Boolean isUserAccountExpired;
    private Boolean isUserAccountLocked;
    private Boolean isUserAccountCredentialsExpired;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isUserAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isUserAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isUserAccountCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
