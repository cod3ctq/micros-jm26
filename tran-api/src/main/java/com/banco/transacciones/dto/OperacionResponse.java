package com.banco.transacciones.dto;

import java.math.BigDecimal;
import java.util.List;

public record OperacionResponse(
        String mensaje,
        String referencia,
        BigDecimal saldoActual,
        List<MovimientoResponse> movimientos
) {}
