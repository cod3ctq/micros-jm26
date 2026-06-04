package com.banco.transacciones.dto;

import com.banco.transacciones.enums.EstadoMovimiento;
import com.banco.transacciones.enums.TipoMovimiento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimientoResponse(
        Long movimientoId,
        Long cuentaId,
        TipoMovimiento tipo,
        EstadoMovimiento estado,
        BigDecimal monto,
        BigDecimal saldoAnterior,
        BigDecimal saldoPosterior,
        String referencia,
        String descripcion,
        Long movimientoRelacionadoId,
        LocalDateTime fechaOperacion
) {}
