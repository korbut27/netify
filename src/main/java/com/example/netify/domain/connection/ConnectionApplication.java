package com.example.netify.domain.connection;

import com.example.netify.domain.tariff.Tariff;
import com.example.netify.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "connection_applications")
@Data
public class ConnectionApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "submission_date", nullable = false)
    private Date submissionDate;

    @Column(name = "closing_date", nullable = false)
    private Date closingDate;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ApplicationStatus status;

}
