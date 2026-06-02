package com.ms_tarjetas.mapper;

//clase que se encarga de transformar lso objetos desde y hacia
// la forma deseada, ya sean entidades,requesr y responses

import com.ms_tarjetas.dto.TarjetasRequest;
import com.ms_tarjetas.dto.TarjetasResponse;
import com.ms_tarjetas.entity.Tarjetas;

public class TarjetasMapper {
    public static Tarjetas toEntity(TarjetasRequest request) {

        Tarjetas t = new Tarjetas();
        t.setCuentaId(request.getCuentaId());
        t.setTipoTarjeta(request.getTipoTarjetaId());
        t.setNumTarjeta(request.getNumTarjeta());
        t.setNip(request.getNip());
        t.setFechaVen(request.getFechaVen());
        t.setStatus("ACTIVO");
        return t;
    }
    //De entity -> response
    // como sale desde el srrvicio hacia el cliente
    public static TarjetasResponse toResponse(Tarjetas tarjetas){
        return new TarjetasResponse(tarjetas.getNumTarjeta(),
                tarjetas.getFechaVen(),tarjetas.getStatus());
    }
    //Actualizar datos detnro de un objeto entidad
    //Remplaza los fatos viejos de una entidad por los nuevos extraidos del request
    public static void updateEntity(Tarjetas tarjetas, TarjetasRequest request){
       tarjetas.setStatus(request.getStatus());
       tarjetas.setFechaVen(request.getFechaVen());


    }
}

