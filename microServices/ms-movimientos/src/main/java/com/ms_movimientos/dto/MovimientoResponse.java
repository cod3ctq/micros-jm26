package com.ms_movimientos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

//Mapean los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesados del movimiento ")
public class MovimientoResponse {

    @Schema(description = "Descripcion del tipo de movimiento", example = "DEPOSITO")
    private String tipo;

    @Schema(description = "Fecha del guardado del movimiento", example = "02/06/2026")
    private LocalDate fechaOP;

    @Schema(description = "descripcion del Monto del movimiento ", example = "5000.00")
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
