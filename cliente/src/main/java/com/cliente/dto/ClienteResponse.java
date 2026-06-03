package com.cliente.dto;


import java.time.LocalDate;

//Mapean los objetos de salida del servicio hacia el cliente
public class ClienteResponse {

    private String nombre;
    private String apP;
    private String apM;
    private LocalDate fechaNac;

    public ClienteResponse(String nombre, String apP, String apM, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApP() {
        return apP;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public String getApM() {
        return apM;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
