package com.example.netify.domain.connection;

import com.example.netify.domain.tariff.Tariff;
import com.example.netify.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "users_connections")
@Data
public class UsersConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private int connectionId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "connection_date")
    private Date connectionDate;

    @Column(name = "status", nullable = false)
    private String status;
}