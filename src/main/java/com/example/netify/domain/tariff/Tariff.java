package com.example.netify.domain.tariff;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tariffs")
@Data
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    private int tariffId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private int cost;

}
