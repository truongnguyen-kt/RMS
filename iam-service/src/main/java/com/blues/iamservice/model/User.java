package com.blues.iamservice.model;

import com.blues.iamservice.enums.GenderEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "tbl_user",
        indexes = {
                @Index(name = "idx_user_name", columnList = "username"),
                @Index(name = "idx_email", columnList = "email")
        }
)
public class User extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "user_name", nullable = false, updatable = false, unique = true, length = 255)
    private String username;

    @Column(name = "email", nullable = false, updatable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "last_sign_in")
    private LocalDateTime lastSignIn;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "avatar", length = 500)
    private String avatar;

    @Column(name = "is_enable", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isEnable = true;

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted = false;

    @Column(name = "login_failed_num", columnDefinition = "INTEGER DEFAULT 0")
    private Integer loginFailedNum;
}
