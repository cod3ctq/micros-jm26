package com.cliente.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "DTO para registrar o actualizar cliente")
public class ClienteRequest {
    @Schema(description = "Identificador del cliente", example = "1")
    private int clienteId;

    @Schema(description = "Nombre del cliente", example = "Carlos")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String nombre;

    @Schema(description = "Apellido paterno del cliente", example = "Sanchez")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String apP;

    @Schema(description = "Apellido materno del cliente", example = "Ramirez")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String apM;

    @Schema(description = "Direccion del cliente", example = "CERRADA COCUITE SUR #2")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 100)
    private String direccion;

    @Schema(description = "Numero de telefono del cliente", example = "2299223210")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Pattern(regexp = "^[0-9]{10}$",message ="Numero de telefono debe de contener 10 digitos numericos" )//MODIFICAR ESTO A @PATTERN @Size(message = "Limite de caracteres superado", max = 10)
    private String telefono;

    @Schema(description = "Correo electronico del cliente", example = "Carlos@email.com")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Email(message = "Correo no Valido")
    private String correo;

    @Schema(description = "Numeros del ine del cliente", example = "INEPUE000100000001")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 18)
    private String ine;

    @Schema(description = "RFC del cliente", example = "ROFA200315AB1")
    @NotBlank(message = "No puede estar en blanco o vacio")
    @Size(message = "Limite de caracteres superado", max = 13)
    private String rfc;

    @Schema(description = "Fecha de nacimiento del cliente", example = "28/03/2000")
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
