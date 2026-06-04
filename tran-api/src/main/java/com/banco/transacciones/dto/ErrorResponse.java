package com.banco.transacciones.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(LocalDateTime fecha, int status, String error, String mensaje, Map<String, String> campos) {}
