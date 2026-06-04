package com.ms_movimientos.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "MOVIMIENTOS")
public class Movimientos implements Serializable {

    @Id
    @Column(name = "MOV_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movID;
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")
    private int cuentaID;
    @Column(name = "TIPO", columnDefinition = "VARCHAR2(100)")
    private String tipo;
    @Column(name = "FECHA_OP", columnDefinition = "DATE")
    private LocalDate fechaOP;
    @Column(name = "MONTO", columnDefinition = "NUMBER(8,2)")
    private double monto;

    public int getMovID() {
        return movID;
    }

    public void setMovID(int movID) {
        this.movID = movID;
    }

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaOP() {
        return fechaOP;
    }

    public void setFechaOP(LocalDate fechaOP) {
        this.fechaOP = fechaOP;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
