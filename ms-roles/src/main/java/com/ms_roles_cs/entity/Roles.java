package com.ms_roles_cs.entity;
//Primer paso: Mapear la entidad o la tabla

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ROLES")
public class Roles implements Serializable {

    @Id //Designa que atributo sera la PK de esta entidad
    @Column(name="ROL_ID", columnDefinition = "NUMBER") //Enlaza el atributo con la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configura la estrategia de generacion del id
    private Integer rolId;
    @Column(name="DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;
    @Column(name="SUELDO", columnDefinition = "NUMBER(8,2)")
    private Double sueldo;

    //No necesita constructores:  utiliza el default(vacio) que Java otorga
    //No se necesita el TO STRING

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}