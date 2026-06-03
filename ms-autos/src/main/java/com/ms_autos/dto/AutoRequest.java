package com.ms_autos.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

// 3
//DTO: Transmision datos
//Se llama Request (peticion) por que mapea los datos que llegaran en las peticiones hacia este servicio
@Schema(description = "DTO para registrar o actualizar un auto")
public class AutoRequest {

    @Schema(description = "Identificador del auto", example = "1")
    private int autoId;

    @Schema(description = "Descripcion del modelo del auto", example = "Corvette C6")
    @NotBlank(message="El modelo no puede quedar vacio o nulo")
    @Size(message="El modelo permite hasta 15 caracteres", max = 15)
    private String modelo;

    @Schema(description = "Año de fabricacion del auto", example = "2013")
    @Digits(integer = 4, fraction = 0)
    @Min(value=1980, message = "El año del auto no debe ser menor a 1980")
    private int año;

    @Schema(description = "Categoria o segmento del auto", example = "Deportivo")
    @NotBlank(message="El tipo no puede quedar vacio o nulo")
    @Size(message="El tipo permite hasta 15 caracteres", max = 15)
    private String tipo;

    @Schema(description = "Identificador de la marca del auto", example = "1")
    @Digits(integer = 1, fraction = 0)
    private int marcaId;

    public AutoRequest(){}

    public AutoRequest(int autoId, String modelo, int año, String tipo, int marcaId) {
        this.autoId = autoId;
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.marcaId = marcaId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }

    @Override
    public String toString() {
        return "AutoRequest{" +
                "autoId=" + autoId +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", tipo='" + tipo + '\'' +
                ", marcaId=" + marcaId +
                '}';
    }
}
