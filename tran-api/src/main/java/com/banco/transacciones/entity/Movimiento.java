package com.banco.transacciones.entity;

import com.banco.transacciones.enums.EstadoMovimiento;
import com.banco.transacciones.enums.TipoMovimiento;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIMIENTO_ID")
    private Long movimientoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUENTA_ID", nullable = false)
    private Cuenta cuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 30)
    private TipoMovimiento tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 20)
    private EstadoMovimiento estado;

    @Column(name = "MONTO", nullable = false, precision = 14, scale = 2)
    private BigDecimal monto;

    @Column(name = "SALDO_ANTERIOR", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldoAnterior;

    @Column(name = "SALDO_POSTERIOR", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldoPosterior;

    @Column(name = "REFERENCIA", nullable = false, length = 50)
    private String referencia;

    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @Column(name = "MOVIMIENTO_RELACIONADO_ID")
    private Long movimientoRelacionadoId;

    @Column(name = "FECHA_OPERACION", nullable = false)
    private LocalDateTime fechaOperacion;

    public Long getMovimientoId() { return movimientoId; }
    public void setMovimientoId(Long movimientoId) { this.movimientoId = movimientoId; }
    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }
    public TipoMovimiento getTipo() { return tipo; }
    public void setTipo(TipoMovimiento tipo) { this.tipo = tipo; }
    public EstadoMovimiento getEstado() { return estado; }
    public void setEstado(EstadoMovimiento estado) { this.estado = estado; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public BigDecimal getSaldoAnterior() { return saldoAnterior; }
    public void setSaldoAnterior(BigDecimal saldoAnterior) { this.saldoAnterior = saldoAnterior; }
    public BigDecimal getSaldoPosterior() { return saldoPosterior; }
    public void setSaldoPosterior(BigDecimal saldoPosterior) { this.saldoPosterior = saldoPosterior; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Long getMovimientoRelacionadoId() { return movimientoRelacionadoId; }
    public void setMovimientoRelacionadoId(Long movimientoRelacionadoId) { this.movimientoRelacionadoId = movimientoRelacionadoId; }
    public LocalDateTime getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(LocalDateTime fechaOperacion) { this.fechaOperacion = fechaOperacion; }
}
