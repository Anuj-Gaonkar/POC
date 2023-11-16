package com.poc.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity implements Persistable<UUID> {

    @Id
    private UUID id;

    private UUID publicId;

    private BigInteger version;

    private LocalDateTime createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String createdBy;

    private String lastModifiedBy;

    @Override
    public boolean isNew() {
        boolean result = Objects.isNull(id);
        this.id = result ? UUID.randomUUID() : this.id;
        return result;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
