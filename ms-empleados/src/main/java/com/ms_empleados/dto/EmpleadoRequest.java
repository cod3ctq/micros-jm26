package com.ms_empleados.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// Capa 3: Clase DTO: Transmisión de datos
// Se llama Request (petición) porque mapea los datos que llegarán en las peticiones hacia este servicio
public class EmpleadoRequest {
    // Atributos
    private int empleadoId;
    @Positive // Anotación para indicar que tiene que ser un número positivo
    private int rolId;
    @NotBlank(message = "El nombre no puede quedar vacío o nulo") // Anotaciones genéricas de validaciones
    @Size(message = "El nombre permite hasta 100 caracteres", max = 100) // Anotación para indicar el tamaño del campo
    private String nombre;
    @NotBlank(message = "El apellido paterno no puede quedar vacío o nulo") // Anotación para indicar que tiene que haber información en el campo
    @Size(message = "El apellido paterno permite hasta 100 caracteres", max = 100)
    private String apP;
    @Size(message = "El apellido materno permite hasta 100 caracteres", max = 100)
    private String apM;
    @Size(message = "El correo permite hasta 100 caracteres", max = 100)
    private String correo;
    @Pattern(regexp = "^[0-9]+$", message = "El campo sólo debe contener números") // Anotación para indicar que en un String sólo se permiten números
    @Size(message = "El teléfono permite hasta 10 caracteres", max = 10)
    private String tel;
    @Size(message = "El status permite hasta 50 caracteres", max = 100)
    private String status;

    // Constructores
    public EmpleadoRequest() {
    }
    public EmpleadoRequest(int empleadoId, int rolId, String nombre, String apP, String apM, String correo, String tel, String status) {
        this.empleadoId = empleadoId;
        this.rolId = rolId;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.correo = correo;
        this.tel = tel;
        this.status = status;
    }

    // Getters/Setters
    public int getEmpleadoId() {
        return empleadoId;
    }
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }
    public int getRolId() {
        return rolId;
    }
    public void setRolId(int rolId) {
        this.rolId = rolId;
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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "EmpleadosRequest{" +
                "empleadoId=" + empleadoId +
                ", rolId=" + rolId +
                ", nombre='" + nombre + '\'' +
                ", apP='" + apP + '\'' +
                ", apM='" + apM + '\'' +
                ", correo='" + correo + '\'' +
                ", tel='" + tel + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}