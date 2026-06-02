package com.ms_tarjetas.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//#3
// DTO: Transmision datos
// se llama Request(peticion) por que mapea los datos que llegaran en las peticines hacie este servicio

public class TarjetasRequest {
    private int tarjetaId;
//@NotBlank(message = "El modelo no puede quedar vacio o nulo")
//@Size(message = "Modelo permite hasta 15 caracteres", max=15)

    private int cuentaId;
    private int tipoTarjetaId;
    @Size(message = "Num tarjeta deberia tener hasta 16 caracteres", max=16, min=16)
    private String numTarjeta;
    private String nip;
    private LocalDate fechaVen;
    private String status;

    public TarjetasRequest(){}


    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    @Override
    public String toString() {
        return "TarjetasRequest{" +
                "tarjetaId=" + tarjetaId +
                ", cuentaId=" + cuentaId +
                ", tipoTarjetaId=" + tipoTarjetaId +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", fechaVen=" + fechaVen +
                ", status='" + status + '\'' +
                '}';
    }

}
