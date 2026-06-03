package com.ms_roles_cs.dto;
//Mapean los objetos de salida del servicio hacia el cliente
public class RolesResponse {
    private Integer rolId;
    private String descripcion;
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
