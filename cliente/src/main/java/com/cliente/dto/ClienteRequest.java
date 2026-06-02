package com.cliente.dto;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClienteRequest {
    private int clienteId;
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String nombre;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String apP;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String apM;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String direccion;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Pattern(regexp = "^[0-9]{10}$",message ="Numero de telefono debe de contener 10 digitos numericos" )//MODIFICAR ESTO A @PATTERN @Size(message = "Limite de caracteres superado", max = 10)
    private String telefono;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Email(message = "Correo no Valido")
    private String correo;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 18)
    private String ine;

    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 13)
    private String rfc;

    @NotNull
    @Past(message= "La fecha no puede ser actual o a futuro")
    private LocalDate fechaNac;

    public ClienteRequest() {}

    public ClienteRequest(int clienteId, String nombre, String apP, String apM, String direccion, String telefono, String correo, String ine, String rfc, LocalDate fechaNac) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaNac = fechaNac;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
