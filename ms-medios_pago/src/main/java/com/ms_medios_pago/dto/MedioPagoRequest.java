package com.ms_medios_pago.dto;

import jakarta.validation.constraints.*;

import jakarta.persistence.Column;
//DTO
//MAPEA LOS DATOS QUE LLEGARON
public class MedioPagoRequest {

    private int medioId;

    @NotBlank(message = "La descripcion no puede quedar vacia")
    @Size(message = "La descripcion solo acepta hasta 100 caracteres", max = 100)
    private String descripcion;

    public MedioPagoRequest(){}

    public MedioPagoRequest(int medioId, String descripcion) {
        this.medioId = medioId;
        this.descripcion = descripcion;
    }

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MedioPagoRequest{" +
                "medioId=" + medioId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
