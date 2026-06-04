package com.banco.transacciones.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record TransferenciaRequest(
        @NotNull Long cuentaOrigenId,
        @NotNull Long cuentaDestinoId,
        @NotNull @DecimalMin(value = "0.01") BigDecimal monto,
        @Size(max = 200) String descripcion
) {}
