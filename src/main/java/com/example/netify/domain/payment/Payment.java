package com.example.netify.domain.payment;

import com.example.netify.domain.tariff.Tariff;
import com.example.netify.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "cost", nullable = false)
    private int cost;
}