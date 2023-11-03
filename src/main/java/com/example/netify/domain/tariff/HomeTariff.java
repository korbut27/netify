package com.example.netify.domain.tariff;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "home_tariffs")
@Data
public class HomeTariff {
    @Id
    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "speed_limit", nullable = false)
    private int speedLimit;

    @ElementCollection
    @CollectionTable(name = "tariff_equipment")
    @Column(name = "equipment")
    @Enumerated(value = EnumType.STRING)
    private Set<Equipment> equipment;

    @ElementCollection
    @CollectionTable(name = "tariff_services")
    @Column(name = "service")
    @Enumerated(value = EnumType.STRING)
    private Set<Service> service;

}
