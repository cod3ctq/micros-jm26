package com.banco.transacciones.controller;

import com.banco.transacciones.dto.*;
import com.banco.transacciones.service.TransaccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Transacciones", description = "Operaciones monetarias sobre cuentas, movimientos y tarjetas")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/transacciones/retiros")
    @Operation(summary = "Realizar retiro", description = "Descuenta saldo de una cuenta activa y registra el movimiento de salida.")
    public ResponseEntity<OperacionResponse> retirar(@Valid @RequestBody RetiroRequest request) {
        return ResponseEntity.ok(transaccionService.retirar(request));
    }

    @PostMapping("/transacciones/depositos")
    @Operation(summary = "Realizar depósito", description = "Aumenta saldo de una cuenta activa y registra el movimiento de entrada.")
    public ResponseEntity<OperacionResponse> depositar(@Valid @RequestBody DepositoRequest request) {
        return ResponseEntity.ok(transaccionService.depositar(request));
    }

    @PostMapping("/transacciones/transferencias")
    @Operation(summary = "Realizar transferencia", description = "Descuenta de una cuenta origen, abona a una cuenta destino y registra ambos movimientos con la misma referencia.")
    public ResponseEntity<OperacionResponse> transferir(@Valid @RequestBody TransferenciaRequest request) {
        return ResponseEntity.ok(transaccionService.transferir(request));
    }

    @PostMapping("/transacciones/pagos")
    @Operation(summary = "Pagar con tarjeta", description = "Valida tarjeta, descuenta de la cuenta asociada y registra el pago.")
    public ResponseEntity<OperacionResponse> pagarConTarjeta(@Valid @RequestBody PagoTarjetaRequest request) {
        return ResponseEntity.ok(transaccionService.pagarConTarjeta(request));
    }

    @GetMapping("/cuentas/{cuentaId}/movimientos")
    @Operation(summary = "Consultar movimientos", description = "Devuelve el historial de movimientos de una cuenta.")
    public ResponseEntity<List<MovimientoResponse>> consultarMovimientos(@PathVariable Long cuentaId) {
        return ResponseEntity.ok(transaccionService.consultarMovimientos(cuentaId));
    }

    @GetMapping("/cuentas/{cuentaId}/saldo/validar")
    @Operation(summary = "Validar saldo suficiente", description = "Indica si la cuenta tiene saldo suficiente para cubrir un monto.")
    public ResponseEntity<SaldoResponse> validarSaldo(
            @PathVariable Long cuentaId,
            @RequestParam @DecimalMin(value = "0.01") BigDecimal monto) {
        return ResponseEntity.ok(transaccionService.validarSaldo(cuentaId, monto));
    }

    @PostMapping("/movimientos/{movimientoId}/revertir")
    @Operation(summary = "Revertir movimiento", description = "Genera un movimiento de reverso y marca el movimiento original como revertido.")
    public ResponseEntity<OperacionResponse> revertir(@PathVariable Long movimientoId) {
        return ResponseEntity.ok(transaccionService.revertirMovimiento(movimientoId));
    }
}
