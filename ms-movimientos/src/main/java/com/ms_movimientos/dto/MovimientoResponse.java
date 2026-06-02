package com.ms_movimientos.dto;

import java.time.LocalDate;

//Mapean los objetos de salida del servicio hacia el cliente
public class MovimientoResponse {

    private String tipo;
    private LocalDate fechaOP;
    private double monto;


    public MovimientoResponse(String tipo, LocalDate fechaOP, double monto) {
        this.tipo = tipo;
        this.fechaOP = fechaOP;
        this.monto = monto;
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
        return "MovimientoResponse{" +
                "tipo='" + tipo + '\'' +
                ", fechaOP=" + fechaOP +
                ", monto=" + monto +
                '}';
    }
}
