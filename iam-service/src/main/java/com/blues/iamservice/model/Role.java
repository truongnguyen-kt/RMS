package com.blues.iamservice.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity(name = "Role")
@Table(
        name = "tbl_role",
        indexes = {
                @Index(name = "idx_role_name", columnList = "name")
        }
)
public class Role extends Auditable implements Serializable {
    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "is_enable", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isEnable = true;

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted = false;
}
