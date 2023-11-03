package com.example.netify.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "adresses")
@Data
public class Adress {
    @Id
    @Column(name = "adress_id")
    private int addressId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "home", nullable = false)
    private String home;

    @Column(name = "flat", nullable = false)
    private int flat;
}
