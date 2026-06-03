package com.ms_empleados.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

// Capa 1: Mapea la entidad/tabla
@Entity // Convierte la Clase POJO en una Entidad
@Table(name = "EMPLEADOS") // Enlaza la Clase con la tabla que va a representar
public class Empleados implements Serializable {
    // Atributos
    @Id // Indica que el siguiente atributo será la Primary Key de esta entidad
    @Column(name = "EMPLEADO_ID", columnDefinition = "NUMBER") // Enlaza el atributo con la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la estrategia de generación del id, autoincrementable y generado en automático
    private int empleadoId;
    @Column(name = "ROL_ID", columnDefinition = "NUMBER") // También podríamos omitir el uso de "cplumnDefinition", Hibernate/JPA se encarga de eso
    private int rolId;
    @Column(name = "NOMBRE", columnDefinition = "VARCHAR2")
    private String nombre;
    @Column(name = "AP_P", columnDefinition = "VARCHAR2")
    private String apP;
    @Column(name = "AP_M", columnDefinition = "VARCHAR2")
    private String apM;
    @Column(name = "FECHA_IN", columnDefinition = "DATE")
    private LocalDate fechaIn;
    @Column(name = "CORREO", columnDefinition = "VARCHAR2")
    private String correo;
    @Column(name = "TEL", columnDefinition = "CHAR")
    private String tel;
    @Column(name = "STATUS", columnDefinition = "VARCHAR2")
    private String status;

    // No necesitaremos crear metodo toString ni constructores, usaremos el default (vacío)

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
    public LocalDate getFechaIn() {
        return fechaIn;
    }
    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
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
}