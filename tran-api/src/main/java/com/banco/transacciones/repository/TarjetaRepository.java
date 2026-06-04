package com.banco.transacciones.repository;

import com.banco.transacciones.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    Optional<Tarjeta> findByNumeroTarjeta(String numeroTarjeta);
}
