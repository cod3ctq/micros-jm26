package com.banco.transacciones.entity;

import com.banco.transacciones.enums.EstadoTarjeta;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TARJETAS")
public class Tarjeta {

    @Id
    @Column(name = "TARJETA_ID")
    private Long tarjetaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUENTA_ID", nullable = false)
    private Cuenta cuenta;

    @Column(name = "NUMERO_TARJETA", nullable = false, unique = true, length = 20)
    private String numeroTarjeta;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 20)
    private EstadoTarjeta estado;

    @Column(name = "FECHA_VENCIMIENTO")
    private LocalDate fechaVencimiento;

    public Long getTarjetaId() { return tarjetaId; }
    public void setTarjetaId(Long tarjetaId) { this.tarjetaId = tarjetaId; }
    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
    public EstadoTarjeta getEstado() { return estado; }
    public void setEstado(EstadoTarjeta estado) { this.estado = estado; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean estaDisponibleParaPago() {
        return EstadoTarjeta.ACTIVA.equals(estado) && (fechaVencimiento == null || !fechaVencimiento.isBefore(LocalDate.now()));
    }
}
