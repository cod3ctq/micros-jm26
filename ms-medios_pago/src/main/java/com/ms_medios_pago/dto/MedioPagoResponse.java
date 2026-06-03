package com.ms_medios_pago.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de respuesta con los datos procesados del medio de pago")
public class MedioPagoResponse {

    @Schema(description = "Descripcion del medio de pago", example = "TRANSFERENCIA")
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
