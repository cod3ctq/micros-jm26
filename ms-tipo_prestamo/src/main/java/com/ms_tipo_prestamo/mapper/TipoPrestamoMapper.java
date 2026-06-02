package com.ms_tipo_prestamo.mapper;
import com.ms_tipo_prestamo.dto.TipoPrestamoRequest;
import com.ms_tipo_prestamo.dto.TipoPretamoResponse;
import com.ms_tipo_prestamo.entity.Tipo_Prestamo;


public class TipoPrestamoMapper {

    public static Tipo_Prestamo toEntity(TipoPrestamoRequest request){

        Tipo_Prestamo tp = new Tipo_Prestamo();
        tp.setPlazo(request.getPlazo());
        tp.setDescripcion(request.getDescripcion());
        tp.setInteres(request.getInteres());
        return tp;

    }

    public static TipoPretamoResponse toResponse(Tipo_Prestamo tp2){
        return new TipoPretamoResponse( tp2.getTipoPrestamoId(),
                tp2.getInteres(),
                tp2.getPlazo());
    }
    public static void updateEntity(Tipo_Prestamo tp2, TipoPrestamoRequest request){
        tp2.setTipoPrestamoId(request.getTipoPrestamoId());
        tp2.setPlazo(request.getPlazo());
        tp2.setInteres(request.getInteres());
        tp2.setDescripcion(request.getDescripcion());

    }




}
