package com.cliente.repository;

import com.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// DAO
@Repository // Establece la responsabilidad de las operaciones de acceso a datos (DAO)
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Aqui ya existen las operaciones basicas resueltas
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.correo = :correoDeEntrada")
    int contarClientesPorCorreo(@Param("correoDeEntrada") String email);
}
