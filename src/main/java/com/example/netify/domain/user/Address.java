package com.example.netify.domain.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Address {
    @Id
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "home", nullable = false)
    private String home;

    @Column(name = "flat", nullable = false)
    private int flat;
}
