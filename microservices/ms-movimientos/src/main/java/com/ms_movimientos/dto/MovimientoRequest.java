package com.ms_movimientos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "DTO para registrar o actualizar un movimiento ")
public class MovimientoRequest {

    @Schema(description = "Identificador del movimiento", example = "1")
    private int movID;

    @Schema(description = "Identificador de la cuenta", example = "1")
    @NotNull
    @Positive
    private int cuentaID;

    @Schema(description = "Categoria o segmento del movimiento", example = "RETIRO")
    @NotBlank(message ="El tipo no puede quedar vacio o nulo")
    @Size(message ="El tipo permite hasta 15 caracteres", max = 100)
    private String tipo;

    @Schema(description = "Segmento donde queda registrada la fecha de operacion")
    @FutureOrPresent
    private LocalDate fechaOP;

    @Schema(description = "segmento donde queda registrado el monto del movimiento")
    @Positive
    @DecimalMin(value = "100.00")
    @DecimalMax(value = "10000.00")
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
