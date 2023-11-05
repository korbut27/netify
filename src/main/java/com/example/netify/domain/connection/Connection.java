package com.example.netify.domain.connection;

import com.example.netify.domain.tariff.Tariff;
import com.example.netify.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "connections")
@Data
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Long connectionId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "connection_date")
    private Date connectionDate;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ConnectionStatus status;
}