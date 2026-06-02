package com.ms_cuentas.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="CUENTAS")
public class Cuentas implements Serializable {

    @Id
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    @Column(name = "CLIENTE_ID", columnDefinition = "NUMBER")
    private int clienteId;

    @Column(name= "TIPO_CUENTA_ID", columnDefinition = "NUMBER")
    private int tipoCuentaId;

    @Column(name = "NUM_CUENTA", columnDefinition = "VARCHAR2(10)")
    private String numCuenta;

    @Column(name = "CLABE", columnDefinition = "CHAR(18)")
    private String clabe;

    @Column(name = "SALDO", columnDefinition = "NUMBER(8,2)")
    private double saldo;

    @Column(name="FECHA_AP", columnDefinition = "DATE")
    private LocalDate fechaAp;

    @Column(name="STATUS", columnDefinition = "CHAR(1)")
    private String status;

    @Column(name="FECHA_AC", columnDefinition = "DATE")
    private LocalDate fechaAc;

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

    public LocalDate getFechaAp() {
        return fechaAp;
    }

    public void setFechaAp(LocalDate fechaAp) {
        this.fechaAp = fechaAp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFechaAc() {
        return fechaAc;
    }

    public void setFechaAc(LocalDate fechaAc) {
        this.fechaAc = fechaAc;
    }
}
