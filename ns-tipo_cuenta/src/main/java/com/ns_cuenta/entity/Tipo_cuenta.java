package com.ns_cuenta.entity;

//Paso 1: mapear la tabla

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TIPO_CUENTA")
public class Tipo_cuenta implements Serializable {

    @Id
    @Column(name = "TIPO_CUENTA_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoCuentaId;
    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;
    @Column(name = "SALDO_MIN", columnDefinition = "NUMBER(8,2)")
    private double saldoMin;
    @Column(name = "SALDO_MAX", columnDefinition = "NUMBER(8,2)")
    private double saldoMax;
    @Column(name = "FECHA_REGISTRO", columnDefinition = "DATE")
    private LocalDate fechaRegistro;
    @Column(name = "FECHA_ACT", columnDefinition = "DATE")
    private LocalDate fechaAct;


    //En esta parte no genero contructor mas el que se genera automaticamente por default.
    //Generamos getters y setters sin generar "to string".


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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(LocalDate fechaAct) {
        this.fechaAct = fechaAct;
    }
}
