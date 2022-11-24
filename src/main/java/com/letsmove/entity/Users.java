package com.letsmove.entity;

import com.letsmove.enums.Role;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;

    private Boolean active;

    @Column(name = "LOGIN",unique = true)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL",unique = true)
    private String email;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "NEW_PASSWORD")
    private String newPassword;
}
