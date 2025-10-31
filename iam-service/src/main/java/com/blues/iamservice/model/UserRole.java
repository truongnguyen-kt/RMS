package com.blues.iamservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "UserRole")
@Table(name = "tbl_user_role")
public class UserRole extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true, insertable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;
}
