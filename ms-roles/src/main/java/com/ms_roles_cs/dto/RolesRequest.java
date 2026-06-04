package com.ms_roles_cs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//Terrcer paso
//DTO: Transmision datos
//Se llama REQUEST (peticion) por que mapea los datos que llegaron en las peticiones hacia este servicio
@Schema(description = "DTO para registrar o actualizar un rol")
public class RolesRequest {
    @Schema(description = "Identificador único del rol", example = "1")
    private Integer rolId;

    @Schema(description = "Descripción o nombre del rol", example = "Administrador")
    @NotBlank(message = "La descripción del rol no puede quedar vacía o nula")
    @Size(min = 3, max = 50, message = "La descripción debe tener entre 3 y 50 caracteres")
    private String descripcion;

    @Schema(description = "Sueldo asociado al rol", example = "15000.00")
    @NotNull(message = "El sueldo es obligatorio")
    @Positive(message = "El sueldo debe ser mayor a cero")
    private Double sueldo;

    public RolesRequest(){}

    public RolesRequest(Integer rolId, String descripcion, Double sueldo) {
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
        return "RolesRequest{" +
                "rolId=" + rolId +
                ", descripcion='" + descripcion + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
