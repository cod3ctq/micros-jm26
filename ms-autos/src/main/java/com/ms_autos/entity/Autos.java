package com.ms_autos.entity;

//1: Mapear la entidad/tabla

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity //Convierte la clase POJO en una entidad
@Table(name="AUTOS") //Enlaza la clase con la tabla que va representar
public class Autos implements Serializable {

    @Id //Designa que atributo sera la PK de esta entidad
    @Column(name="MODELO_ID", columnDefinition = "NUMBER") //Enlaza el atributo con la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configura la estrategia de generacion del id
    private int autoId;
    @Column(name="MODELO", columnDefinition = "NVARCHAR2(15)")
    private String modelo;
    @Column(name="AÑO", columnDefinition = "NUMBER")
    private int año;
    @Column(name="TIPO", columnDefinition = "NVARCHAR2(15)")
    private String tipo;
    @Column(name="MARCA_ID", columnDefinition = "NUMBER")
    private int marcaId;
    @Column(name="FECHA_REGISTRO", columnDefinition = "DATE")
    private LocalDate fechaRegistro;
    @Column(name="FECHA_ACT", columnDefinition = "DATE")
    private LocalDate fechaAct;

    //No necesito constructores : utiliza el default(vacio) que Java otorga

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
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
