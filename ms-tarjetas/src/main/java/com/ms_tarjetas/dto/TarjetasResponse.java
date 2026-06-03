package com.ms_tarjetas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

//mapea los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesados de la tarjeta")
public class TarjetasResponse {

   @Schema(description = "Numero de tarjeta de cliente", example = "5273849462736452")
    private String numTarjeta;

   @Schema(description = "Fecha de vencimiento asociada a la tarjeta")
    private LocalDate fechaVen;

   @Schema(description = "Estado de la tarjeta", example = "BLOQUEADO")
    private String status;

    public TarjetasResponse(String numTarjeta, LocalDate fechaVen, String status) {
        this.numTarjeta = numTarjeta;
        this.fechaVen = fechaVen;
        this.status = status;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
