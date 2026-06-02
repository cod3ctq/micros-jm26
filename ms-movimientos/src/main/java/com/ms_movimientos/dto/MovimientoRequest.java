package com.ms_movimientos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


public class MovimientoRequest {

    private int movID;

    @NotNull
    @Positive
    private int cuentaID;

    @NotBlank(message ="El tipo no puede quedar vacio o nulo")
    @Size(message ="El tipo permite hasta 15 caracteres", max = 100)
    private String tipo;

    @FutureOrPresent
    private LocalDate fechaOP;

    @Positive
    @DecimalMin(value = "100.00")
    @DecimalMax(value = "99999.99")
    private double monto;

    public MovimientoRequest(){}

    public MovimientoRequest(int movID, int cuentaID, String tipo, LocalDate fechaOP, double monto) {
        this.movID = movID;
        this.cuentaID = cuentaID;
        this.tipo = tipo;
        this.fechaOP = fechaOP;
        this.monto = monto;
    }

    public int getMovID() {
        return movID;
    }

    public void setMovID(int movID) {
        this.movID = movID;
    }

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaOP() {
        return fechaOP;
    }

    public void setFechaOP(LocalDate fechaOP) {
        this.fechaOP = fechaOP;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "MovimientoRequest{" +
                "movID=" + movID +
                ", cuentaID=" + cuentaID +
                ", tipo='" + tipo + '\'' +
                ", fechaOP=" + fechaOP +
                ", monto=" + monto +
                '}';
    }
}
