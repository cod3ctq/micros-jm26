package com.ms_roles_cs.dto;

import io.swagger.v3.oas.annotations.media.Schema;

//Mapean los objetos de salida del servicio hacia el cliente
//Se llama Response por que mapean los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta para la información de un rol")
public class RolesResponse {
    @Schema(description = "Identificador único del rol", example = "1")
    private Integer rolId;
    @Schema(description = "Descripción o nombre del rol", example = "Administrador")
    private String descripcion;
    @Schema(description = "Sueldo asociado al rol", example = "15000.00")
    private Double sueldo;

    public RolesResponse(Integer rolId, String descripcion, Double sueldo) {
        this.rolId = rolId;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
    }

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

    @Override
    public String toString() {
        return "RolesResponse{" +
                "rolId=" + rolId +
                ", descripcion='" + descripcion + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }


}
