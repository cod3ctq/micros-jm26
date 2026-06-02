package com.ms_medios_pago.dto;

public class MedioPagoResponse {

    private String descripcion;

    public MedioPagoResponse(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MedioPagoResponse{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
