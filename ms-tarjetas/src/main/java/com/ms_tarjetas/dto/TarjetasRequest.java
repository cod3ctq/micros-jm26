package com.ms_tarjetas.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//#3
// DTO: Transmision datos
// se llama Request(peticion) por que mapea los datos que llegaran en las peticines hacie este servicio
@Schema (description = "DTO para registrar o actualizar un auto")
public class TarjetasRequest {
    private int tarjetaId;
//@NotBlank(message = "El modelo no puede quedar vacio o nulo")
//@Size(message = "Modelo permite hasta 15 caracteres", max=15)

    @Schema(description = "identificador de tarjetas", example ="1")
    private int cuentaId;

    @Schema(description = "Descripcion del tipo de tarjeta", example = "NOMINA") private int tipoTarjetaId;

    @Schema(description = "Numero de tarjeta")
    @Size(message = "Num tarjeta deberia tener hasta 16 caracteres", max=16, min=16)
    private String numTarjeta;

    @Schema(description = "NUmero de nip")
    private String nip;

    @Schema(description = "Fecha de vencimiento de la tarjeta")
    private LocalDate fechaVen;

    @Schema(description = "Estado de la tarjeta", example = "INACTIVO")
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
