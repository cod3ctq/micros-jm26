package com.ms_cuentas.dto;

import jakarta.validation.constraints.*;

public class CuentaRequest {

    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int cuentaId;
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int clienteId;
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int tipoCuentaId;
    @NotBlank(message = "El modelo no puede quedar vacio o nulo")
    @Size(max = 10, min = 10, message = "El modelo permite hasta 10 caracteres")
    private String numCuenta;
    @NotBlank(message = "El modelo no puede quedar vacio o nulo")
    @Size(max = 18, min =16, message = "El modelo permite hasta 18 caracteres")
    private String clabe;
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    @Digits(integer = 6, fraction = 2, message = "El modelo debe ser de 6 digitos enteros y 2 decimales")
    private double saldo;
    private String status;

    public CuentaRequest(int cuentaId, int clienteId, int tipoCuentaId, String numCuenta, String clabe, double saldo, String status) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.status = status;
    }

    public CuentaRequest() {

    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CuentaRequest{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", status='" + status + '\'' +
                '}';
    }
}
