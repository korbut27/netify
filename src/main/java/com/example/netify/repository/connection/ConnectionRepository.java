package com.example.netify.repository.connection;

import com.example.netify.domain.connection.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, Long>{
}
