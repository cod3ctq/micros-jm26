package com.banco.transacciones.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record DepositoRequest(
        @NotNull Long cuentaId,
        @NotNull @DecimalMin(value = "0.01") BigDecimal monto,
        @Size(max = 200) String descripcion
) {}
