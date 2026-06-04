package com.banco.transacciones.entity;

import com.banco.transacciones.enums.EstadoCuenta;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @Column(name = "CUENTA_ID")
    private Long cuentaId;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "NUMERO_CUENTA", nullable = false, unique = true, length = 30)
    private String numeroCuenta;

    @Column(name = "SALDO", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 20)
    private EstadoCuenta estado;

    public Long getCuentaId() { return cuentaId; }
    public void setCuentaId(Long cuentaId) { this.cuentaId = cuentaId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
    public EstadoCuenta getEstado() { return estado; }
    public void setEstado(EstadoCuenta estado) { this.estado = estado; }

    public boolean estaActiva() { return EstadoCuenta.ACTIVA.equals(estado); }
    public boolean tieneSaldoSuficiente(BigDecimal monto) { return saldo != null && saldo.compareTo(monto) >= 0; }
    public void descontar(BigDecimal monto) { this.saldo = this.saldo.subtract(monto); }
    public void aumentar(BigDecimal monto) { this.saldo = this.saldo.add(monto); }
}
