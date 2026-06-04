package com.banco.transacciones.service;

import com.banco.transacciones.dto.*;
import com.banco.transacciones.entity.Cuenta;
import com.banco.transacciones.entity.Movimiento;
import com.banco.transacciones.entity.Tarjeta;
import com.banco.transacciones.enums.EstadoMovimiento;
import com.banco.transacciones.enums.TipoMovimiento;
import com.banco.transacciones.exception.BusinessException;
import com.banco.transacciones.exception.ResourceNotFoundException;
import com.banco.transacciones.mapper.MovimientoMapper;
import com.banco.transacciones.repository.CuentaRepository;
import com.banco.transacciones.repository.MovimientoRepository;
import com.banco.transacciones.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransaccionService {

    @Autowired
    private  CuentaRepository cuentaRepository;

    @Autowired
    private  TarjetaRepository tarjetaRepository;

    @Autowired
    private  MovimientoRepository movimientoRepository;

    @Autowired
    private  MovimientoMapper movimientoMapper;



    @Transactional
    public OperacionResponse retirar(RetiroRequest request) {
        Cuenta cuenta = obtenerCuentaBloqueada(request.cuentaId());
        validarCuentaActiva(cuenta);
        validarSaldo(cuenta, request.monto());

        BigDecimal saldoAnterior = cuenta.getSaldo();
        cuenta.descontar(request.monto());
        cuentaRepository.save(cuenta);

        Movimiento movimiento = movimientoMapper.crear(
                cuenta,
                TipoMovimiento.RETIRO,
                request.monto(),
                saldoAnterior,
                cuenta.getSaldo(),
                generarReferencia("RET"),
                request.descripcion(),
                null
        );
        movimientoRepository.save(movimiento);

        return respuesta("Retiro aplicado correctamente", movimiento.getReferencia(), cuenta.getSaldo(), List.of(movimiento));
    }

    @Transactional
    public OperacionResponse depositar(DepositoRequest request) {
        Cuenta cuenta = obtenerCuentaBloqueada(request.cuentaId());
        validarCuentaActiva(cuenta);

        BigDecimal saldoAnterior = cuenta.getSaldo();
        cuenta.aumentar(request.monto());
        cuentaRepository.save(cuenta);

        Movimiento movimiento = movimientoMapper.crear(
                cuenta,
                TipoMovimiento.DEPOSITO,
                request.monto(),
                saldoAnterior,
                cuenta.getSaldo(),
                generarReferencia("DEP"),
                request.descripcion(),
                null
        );
        movimientoRepository.save(movimiento);

        return respuesta("Depósito aplicado correctamente", movimiento.getReferencia(), cuenta.getSaldo(), List.of(movimiento));
    }

    @Transactional
    public OperacionResponse transferir(TransferenciaRequest request) {
        if (request.cuentaOrigenId().equals(request.cuentaDestinoId())) {
            throw new BusinessException("La cuenta origen y destino no pueden ser la misma");
        }

        Cuenta origen = obtenerCuentaBloqueada(request.cuentaOrigenId());
        Cuenta destino = obtenerCuentaBloqueada(request.cuentaDestinoId());

        validarCuentaActiva(origen);
        validarCuentaActiva(destino);
        validarSaldo(origen, request.monto());

        String referencia = generarReferencia("TRF");

        BigDecimal saldoAnteriorOrigen = origen.getSaldo();
        origen.descontar(request.monto());
        cuentaRepository.save(origen);

        Movimiento salida = movimientoMapper.crear(
                origen,
                TipoMovimiento.TRANSFERENCIA_SALIDA,
                request.monto(),
                saldoAnteriorOrigen,
                origen.getSaldo(),
                referencia,
                request.descripcion(),
                null
        );
        movimientoRepository.save(salida);

        BigDecimal saldoAnteriorDestino = destino.getSaldo();
        destino.aumentar(request.monto());
        cuentaRepository.save(destino);

        Movimiento entrada = movimientoMapper.crear(
                destino,
                TipoMovimiento.TRANSFERENCIA_ENTRADA,
                request.monto(),
                saldoAnteriorDestino,
                destino.getSaldo(),
                referencia,
                "Entrada por transferencia desde cuenta " + origen.getCuentaId(),
                salida.getMovimientoId()
        );
        movimientoRepository.save(entrada);

        salida.setMovimientoRelacionadoId(entrada.getMovimientoId());
        movimientoRepository.save(salida);

        return respuesta("Transferencia aplicada correctamente", referencia, origen.getSaldo(), List.of(salida, entrada));
    }

    @Transactional
    public OperacionResponse pagarConTarjeta(PagoTarjetaRequest request) {
        Tarjeta tarjeta = tarjetaRepository.findByNumeroTarjeta(request.numeroTarjeta())
                .orElseThrow(() -> new ResourceNotFoundException("No existe la tarjeta indicada"));

        if (!tarjeta.estaDisponibleParaPago()) {
            throw new BusinessException("La tarjeta no está disponible para realizar pagos");
        }

        Cuenta cuenta = obtenerCuentaBloqueada(tarjeta.getCuenta().getCuentaId());
        validarCuentaActiva(cuenta);
        validarSaldo(cuenta, request.monto());

        BigDecimal saldoAnterior = cuenta.getSaldo();
        cuenta.descontar(request.monto());
        cuentaRepository.save(cuenta);

        Movimiento movimiento = movimientoMapper.crear(
                cuenta,
                TipoMovimiento.PAGO_TARJETA,
                request.monto(),
                saldoAnterior,
                cuenta.getSaldo(),
                generarReferencia("PAG"),
                "Pago en " + request.comercio() + detalle(request.descripcion()),
                null
        );
        movimientoRepository.save(movimiento);

        return respuesta("Pago con tarjeta aplicado correctamente", movimiento.getReferencia(), cuenta.getSaldo(), List.of(movimiento));
    }

    @Transactional(readOnly = true)
    public List<MovimientoResponse> consultarMovimientos(Long cuentaId) {
        if (!cuentaRepository.existsById(cuentaId)) {
            throw new ResourceNotFoundException("No existe la cuenta indicada");
        }
        return movimientoRepository.findByCuentaCuentaIdOrderByFechaOperacionDesc(cuentaId)
                .stream()
                .map(movimientoMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public SaldoResponse validarSaldo(Long cuentaId, BigDecimal monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la cuenta indicada"));
        return new SaldoResponse(cuenta.getCuentaId(), cuenta.getSaldo(), cuenta.getEstado(), cuenta.tieneSaldoSuficiente(monto));
    }

    @Transactional
    public OperacionResponse revertirMovimiento(Long movimientoId) {
        Movimiento original = movimientoRepository.findById(movimientoId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el movimiento indicado"));

        if (EstadoMovimiento.REVERTIDO.equals(original.getEstado())) {
            throw new BusinessException("El movimiento ya fue revertido");
        }
        if (movimientoRepository.existsByMovimientoRelacionadoId(movimientoId)) {
            throw new BusinessException("Ya existe un reverso asociado a este movimiento");
        }

        Cuenta cuenta = obtenerCuentaBloqueada(original.getCuenta().getCuentaId());
        validarCuentaActiva(cuenta);

        BigDecimal saldoAnterior = cuenta.getSaldo();
        if (esCargo(original.getTipo())) {
            cuenta.aumentar(original.getMonto());
        } else {
            validarSaldo(cuenta, original.getMonto());
            cuenta.descontar(original.getMonto());
        }
        cuentaRepository.save(cuenta);

        original.setEstado(EstadoMovimiento.REVERTIDO);
        movimientoRepository.save(original);

        Movimiento reverso = movimientoMapper.crear(
                cuenta,
                TipoMovimiento.REVERSO,
                original.getMonto(),
                saldoAnterior,
                cuenta.getSaldo(),
                generarReferencia("REV"),
                "Reverso del movimiento " + original.getMovimientoId(),
                original.getMovimientoId()
        );
        movimientoRepository.save(reverso);

        return respuesta("Movimiento revertido correctamente", reverso.getReferencia(), cuenta.getSaldo(), List.of(original, reverso));
    }

    private Cuenta obtenerCuentaBloqueada(Long cuentaId) {
        return cuentaRepository.bloquearPorId(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la cuenta indicada"));
    }

    private void validarCuentaActiva(Cuenta cuenta) {
        if (!cuenta.estaActiva()) {
            throw new BusinessException("La cuenta " + cuenta.getCuentaId() + " no está activa");
        }
    }

    private void validarSaldo(Cuenta cuenta, BigDecimal monto) {
        if (!cuenta.tieneSaldoSuficiente(monto)) {
            throw new BusinessException("La cuenta no tiene saldo suficiente");
        }
    }

    private boolean esCargo(TipoMovimiento tipo) {
        return TipoMovimiento.RETIRO.equals(tipo)
                || TipoMovimiento.TRANSFERENCIA_SALIDA.equals(tipo)
                || TipoMovimiento.PAGO_TARJETA.equals(tipo);
    }

    private OperacionResponse respuesta(String mensaje, String referencia, BigDecimal saldoActual, List<Movimiento> movimientos) {
        return new OperacionResponse(
                mensaje,
                referencia,
                saldoActual,
                movimientos.stream().map(movimientoMapper::toResponse).toList()
        );
    }

    private String generarReferencia(String prefijo) {
        return prefijo + "-" + LocalDateTime.now().toString().replace(":", "").substring(0, 15) + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private String detalle(String descripcion) {
        return descripcion == null || descripcion.isBlank() ? "" : " - " + descripcion;
    }
}
