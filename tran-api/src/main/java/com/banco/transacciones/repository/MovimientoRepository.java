package com.banco.transacciones.repository;

import com.banco.transacciones.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaCuentaIdOrderByFechaOperacionDesc(Long cuentaId);
    boolean existsByMovimientoRelacionadoId(Long movimientoRelacionadoId);
}
