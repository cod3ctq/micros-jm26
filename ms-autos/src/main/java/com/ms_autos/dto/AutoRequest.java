package com.ms_autos.dto;

// 3
//DTO: Transmision datos
//Se llama Request (peticion) por que mapea los datos que llegaran en las peticiones hacia este servicio
public class AutoRequest {
    private int autoId;
    private String modelo;
    private int año;
    private String tipo;
    private int marcaId;

    public AutoRequest(){}

    public AutoRequest(int autoId, String modelo, int año, String tipo, int marcaId) {
        this.autoId = autoId;
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.marcaId = marcaId;
    }

    public int getAutoId() {

        return autoId;
    }

    public void setAutoId(int autoId)
    {
        this.autoId = autoId;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo)
    {
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

    @Override
    public String toString() {
        return "AutoRequest{" +
                "autoId=" + autoId +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", tipo='" + tipo + '\'' +
                ", marcaId=" + marcaId +
                '}';
    }
}
