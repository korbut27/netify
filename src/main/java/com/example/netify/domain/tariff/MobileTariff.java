package com.example.netify.domain.tariff;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mobile_tariffs")
@Data
public class MobileTariff {
    @Id
    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "megabytes_includes", nullable = false)
    private int megabytesIncludes;

    @Column(name = "incoming_minutes", nullable = false)
    private int incomingMinutes;

    @Column(name = "outgoing_minutes", nullable = false)
    private int outgoingMinutes;
}