package com.ms_tipo_prestamo.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="TIPO_PRESTAMO")
public class Tipo_Prestamo implements Serializable {

    //Mapear la entidad/tabla
    @Id
    @Column(name="TIPO_PRESTAMO_ID",columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoPrestamoId;
    @Column(name="DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;
    @Column(name="INTERES", columnDefinition = "NUMBER")
    private double interes;
    @Column(name="PLAZO", columnDefinition = "NUMBER")
    private double plazo;

    //No se necesitan constructores :utiliza el default(vacio) que java otorga


    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "Tipo_Prestamo{" +
                "tipoPrestamoId=" + tipoPrestamoId +
                ", descripcion='" + descripcion + '\'' +
                ", interes=" + interes +
                ", plazo=" + plazo +
                '}';
    }
}
