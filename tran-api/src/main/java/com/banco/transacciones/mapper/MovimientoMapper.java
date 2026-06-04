package com.banco.transacciones.mapper;

import com.banco.transacciones.dto.MovimientoResponse;
import com.banco.transacciones.entity.Cuenta;
import com.banco.transacciones.entity.Movimiento;
import com.banco.transacciones.enums.EstadoMovimiento;
import com.banco.transacciones.enums.TipoMovimiento;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class MovimientoMapper {

    public Movimiento crear(Cuenta cuenta, TipoMovimiento tipo, BigDecimal monto, BigDecimal saldoAnterior,
                            BigDecimal saldoPosterior, String referencia, String descripcion, Long relacionadoId) {
        Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setTipo(tipo);
        movimiento.setEstado(EstadoMovimiento.APLICADO);
        movimiento.setMonto(monto);
        movimiento.setSaldoAnterior(saldoAnterior);
        movimiento.setSaldoPosterior(saldoPosterior);
        movimiento.setReferencia(referencia);
        movimiento.setDescripcion(descripcion);
        movimiento.setMovimientoRelacionadoId(relacionadoId);
        movimiento.setFechaOperacion(LocalDateTime.now());
        return movimiento;
    }

    public MovimientoResponse toResponse(Movimiento movimiento) {
        return new MovimientoResponse(
                movimiento.getMovimientoId(),
                movimiento.getCuenta().getCuentaId(),
                movimiento.getTipo(),
                movimiento.getEstado(),
                movimiento.getMonto(),
                movimiento.getSaldoAnterior(),
                movimiento.getSaldoPosterior(),
                movimiento.getReferencia(),
                movimiento.getDescripcion(),
                movimiento.getMovimientoRelacionadoId(),
                movimiento.getFechaOperacion()
        );
    }
}
