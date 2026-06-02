package com.ms_tipo_prestamo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class TipoPrestamoRequest {

    private int tipoPrestamoId;

    @NotBlank(message = "La descripcion no puede quedar vacia")
    @Size(message = "El modelo permite hasta 15 caracteres", max = 15)
    private String descripcion;
    private double interes;
    private double plazo;

  public TipoPrestamoRequest(){}

    public TipoPrestamoRequest(int tipoPrestamoId, String descripcion, double interes, double plazo) {
        this.tipoPrestamoId = tipoPrestamoId;
        this.descripcion = descripcion;
        this.interes = interes;
        this.plazo = plazo;
    }

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "TipoPrestamoRequest{" +
                "tipoPrestamoId=" + tipoPrestamoId +
                ", descripcion='" + descripcion + '\'' +
                ", interes=" + interes +
                ", plazo=" + plazo +
                '}';
    }
}
