package com.ms_tipo_prestamo.dto;

public class TipoPretamoResponse {
    private String tipo;
    private double interes;
    private int plazo;


    public TipoPretamoResponse(String tipo, double interes, int plazo) {
        this.tipo = tipo;
        this.interes = interes;
        this.plazo = plazo;
    }

    public TipoPretamoResponse(int tipoPrestamoId, double interes, double plazo) {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double interes() {
        return interes;
    }

    public void setInterez(double interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "TipoPretamoResponse{" +
                "tipo='" + tipo + '\'' +
                ", interez=" + interes +
                ", plazo=" + plazo +
                '}';
    }
}
