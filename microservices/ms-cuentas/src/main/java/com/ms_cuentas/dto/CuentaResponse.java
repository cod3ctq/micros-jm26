package com.ms_cuentas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO parade respuesta con los datos procesados de la cuenta")
public class CuentaResponse {

    @Schema(description = "Tipo de cuenta", example = "1")
    private int tipoCuenta;
    @Schema(description = "Numero de cuenta", example = "1000000001")
    private String numCuenta;
    @Schema(description = "Numero de CLABE", example = "002180000000000001")
    private String clabe;
    @Schema(description = "Saldo de la cuenta", example = "1000")
    private double saldo;
    @Schema(description = "Fecha de apertura de la cuenta", example = "01-JUN-26")
    private LocalDate fechaAp;
    @Schema(description = "Fecha de alguna actualizacion", example = "01-JUN-26")
    private LocalDate fechaAc;

    public CuentaResponse(int tipoCuenta, String numCuenta, String clabe, double saldo, LocalDate fechaAp, LocalDate fechaAc) {
        this.tipoCuenta = tipoCuenta;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fechaAp = fechaAp;
        this.fechaAc = fechaAc;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaAp() {
        return fechaAp;
    }

    public void setFechaAp(LocalDate fechaAp) {
        this.fechaAp = fechaAp;
    }

    public LocalDate getFechaAc() {
        return fechaAc;
    }

    public void setFechaAc(LocalDate fechaAc) {
        this.fechaAc = fechaAc;
    }
}
