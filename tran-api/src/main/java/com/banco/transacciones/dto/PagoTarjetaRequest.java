package com.banco.transacciones.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record PagoTarjetaRequest(
        @NotBlank String numeroTarjeta,
        @NotNull @DecimalMin(value = "0.01") BigDecimal monto,
        @NotBlank @Size(max = 120) String comercio,
        @Size(max = 200) String descripcion
) {}
