package com.example.netify.domain.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "balance")
    private int balance;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @ElementCollection
    @CollectionTable(name = "users_roles")
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @ElementCollection
    @CollectionTable(name = "users_adresses", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "adress_id")
    private Set<Integer> addresses;

}

