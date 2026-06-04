package com.ms_cuentas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para registrar o actualizar cuenta")
public class CuentaRequest {

    @Schema(description = "identificador de la cuenta", example ="1")
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int cuentaId;
    @Schema(description = "identificador del cliente", example = "1")
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int clienteId;
    @Schema(description = "identificador del tipo de cuenta", example = "1")
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    private int tipoCuentaId;
    @Schema(description = "Numero de la cuenta", example = "1000000001")
    @NotBlank(message = "El modelo no puede quedar vacio o nulo")
    @Size(max = 10, min = 10, message = "El modelo permite hasta 10 caracteres")
    private String numCuenta;
    @Schema(description = "Numero de la CLABE", example = "002180000000000001")
    @NotBlank(message = "El modelo no puede quedar vacio o nulo")
    @Size(max = 18, min =16, message = "El modelo permite hasta 18 caracteres")
    private String clabe;
    @Schema(description = "Saldo en la cuenta", example = "1000")
    @NotNull(message = "El modelo no puede quedar vacio o nulo")
    @Digits(integer = 6, fraction = 2, message = "El modelo debe ser de 6 digitos enteros y 2 decimales")
    private double saldo;
    @Schema(description = "Estado de la cuenta", example = "1")
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
