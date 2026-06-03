package com.ns_cuenta.dto;

//Paso 3: Crear el Request
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class TipoCuentaRequest {

    private int tipoCuentaId;


    @NotBlank(message = "Descripcion no puede quedar vacio o nulo")
    @Size(message = "El modelo permite hasta 100 caracteres", max = 100)
    private String descripcion;

    @NotNull(message = "SaldoMin es obligatorio")
    @DecimalMin("0.00")
    @DecimalMax("999999.99")
    @Digits(integer = 6, fraction = 2)
    private Double saldoMin;

    @NotNull(message = "SaldoMax es obligatorio")
    @DecimalMin("0.00")
    @DecimalMax("999999.99")
    @Digits(integer = 6, fraction = 2)
    private Double saldoMax;


    public TipoCuentaRequest(){}

    public TipoCuentaRequest(int tipoCuentaId, String descripcion, double saldoMin, double saldoMax) {
        this.tipoCuentaId = tipoCuentaId;
        this.descripcion = descripcion;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
    }


    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    @Override
    public String toString() {
        return "TipoCuentaRequest{" +
                "tipoCuentaId=" + tipoCuentaId +
                ", descripcion='" + descripcion + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }
}


