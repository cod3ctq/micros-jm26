package com.ms_cuentas.dto;

import java.time.LocalDate;

public class CuentaResponse {

    private int tipoCuenta;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fechaAp;
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
