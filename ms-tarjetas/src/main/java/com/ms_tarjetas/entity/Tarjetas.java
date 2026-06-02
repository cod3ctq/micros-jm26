package com.ms_tarjetas.entity;
//1: mapear la entidad/tabla

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity // Convierte la clase POJO en una entidad
@Table(name="TARJETAS")//enlaza la clase con la tabla que va representar
public class Tarjetas implements Serializable{

    @Id
    @Column(name="TARJETA_ID", columnDefinition = "NUMBER")//enlaza el atributo con la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)//configura la estrategia de generacion del id
    private int tarjetaId;
    @Column(name="CUENTA_ID",columnDefinition = "NVARCHAR2(15)")
    private int cuentaId;
    @Column(name="TIPO_TARJETA_ID",columnDefinition = "NVARCHAR2(15)")
    private int tipoTarjeta;
    @Column(name="NUM_TARJETA",columnDefinition = "NVARCHAR2(15)")
    private String numTarjeta;
    @Column(name="NIP",columnDefinition= "NVARCHAR2(15)")
    private String nip;
    @Column(name="FECHA_VEN",columnDefinition = "NVARCHAR2(15)")
    private LocalDate fechaVen;
    @Column(name="STATUS",columnDefinition = "NVARCHAR2(15)")
    private String status;

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
