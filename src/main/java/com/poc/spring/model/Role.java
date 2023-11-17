package com.poc.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    private String description;
    private String status;
}
