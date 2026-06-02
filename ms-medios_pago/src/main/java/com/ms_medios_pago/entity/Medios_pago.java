package com.ms_medios_pago.entity;

//1. Mapear la entidad/tabla

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="MEDIOS_PAGO")

public class Medios_pago implements Serializable {

    @Id //definiendo que atributo sera la PK
    @Column(name="MEDIO_ID", columnDefinition = "NUMBER")  //enlanzando el atributo con la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configura la estrategia de generacion del ID
    private int medioId;
    @Column(name="DESCRIPCION", columnDefinition = "NVARCHAR2(15)")
    private String descripcion;

    //No se necesita constructores


    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
