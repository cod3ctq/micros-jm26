package com.ms_medios_pago.mapper;

import com.ms_medios_pago.dto.MedioPagoRequest;
import com.ms_medios_pago.dto.MedioPagoResponse;
import com.ms_medios_pago.entity.Medios_pago;

//Clase que se encarga de transformar los objetos desde y hacia la forma deseada,
// ya sean entidades, request y response
public class MedioPagoMapper {

    //De request ->
    //como llega desde el cliente hacia como debe llegar a la base

    public static Medios_pago toEntity (MedioPagoRequest request){

        Medios_pago mp = new Medios_pago();

        mp.setDescripcion(request.getDescripcion());

        return mp;

    }

    //De entity -> response
    //Como sale del servicio a como va al cliente

    public static MedioPagoResponse toResponse(Medios_pago medio_pago){
        return new MedioPagoResponse(medio_pago.getDescripcion());
    }

    //Actualizar datos dentro de un objeto entidad
    //Reemplazar los datos viejos de una entidad por los nuevos extraidos del request
    public static void updateEntity(Medios_pago medios_pago, MedioPagoRequest request){
        medios_pago.setDescripcion(request.getDescripcion());
    }



}
