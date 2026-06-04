package com.banco.transacciones.dto;

import com.banco.transacciones.enums.EstadoCuenta;
import java.math.BigDecimal;

public record SaldoResponse(Long cuentaId, BigDecimal saldo, EstadoCuenta estado, boolean saldoSuficiente) {}
