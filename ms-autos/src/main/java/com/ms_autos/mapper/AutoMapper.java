package com.ms_autos.mapper;

import com.ms_autos.dto.AutoRequest;
import com.ms_autos.dto.AutoResponse;
import com.ms_autos.entity.Autos;

import java.time.LocalDate;

//Clase que se encarga de transformar los objetos desde y hacia la forma deseada,
// ya sean entidades, request y response
public class AutoMapper {

    //De request -> entity
    //"Como llega desde el cliente hacia como debe llegar a la base"
    public static Autos toEntity(AutoRequest request){
        Autos a = new Autos();
        a.setAño(request.getAño());
        a.setModelo(request.getModelo());
        a.setMarcaId(request.getMarcaId());
        a.setTipo(request.getTipo());
        a.setFechaRegistro(LocalDate.now());
        return a;
    }
    //De entity -> response
    //"Como sale desde el servicio hacia el cliente"
    public static AutoResponse toResponse(Autos auto){
        return new AutoResponse(auto.getModelo(),
                auto.getAño(),auto.getTipo(),
                auto.getFechaRegistro());
    }
    //Actualizar datos dentro de un objeto entidad
    //"Reemplaza los datos viejos de una entidad por los nuevos extraidos del request"
    public static void updateEntity(Autos auto, AutoRequest request){
        auto.setModelo(request.getModelo());
        auto.setTipo(request.getTipo());
        auto.setMarcaId(request.getMarcaId());
        auto.setAño(request.getAño());
        auto.setFechaAct(LocalDate.now());
    }

}
