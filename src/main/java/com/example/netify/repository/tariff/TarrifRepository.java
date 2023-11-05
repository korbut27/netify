package com.example.netify.repository.tariff;

import com.example.netify.domain.tariff.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarrifRepository extends JpaRepository<Tariff, Long> {
}
