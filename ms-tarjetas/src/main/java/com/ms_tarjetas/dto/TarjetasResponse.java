package com.ms_tarjetas.dto;

import java.time.LocalDate;

//mapea los objetos de salida del servicio hacia el cliente
public class TarjetasResponse {

    private String numTarjeta;
    private LocalDate fechaVen;
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
