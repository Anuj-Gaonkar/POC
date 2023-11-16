package com.poc.spring.model;

import java.util.Optional;

public enum RoleName {
    USER("USER"),
    ADMIN("ADMIN");

    RoleName(String roleName) {
        this.roleName = roleName;
    }

    private final String roleName;

    public static Optional<RoleName> getRoleName(String roleName) {
        for (RoleName r : values())
            if (r.roleName.equalsIgnoreCase(roleName))
                return Optional.of(r);
        return Optional.empty();
    }
}
