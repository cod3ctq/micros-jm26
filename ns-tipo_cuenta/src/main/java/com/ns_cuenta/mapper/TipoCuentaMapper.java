package com.ns_cuenta.mapper;


import com.ns_cuenta.dto.TipoCuentaRequest;
import com.ns_cuenta.dto.TipoCuentaResponse;
import com.ns_cuenta.entity.Tipo_cuenta;

import java.time.LocalDate;

//Clase que se encarga de transformar los objetos desde y hacia la forma deseada,
// ya sean entidades, request y response.
public class TipoCuentaMapper {

    //De request -> Hacia entity
    //*Como llega desde el cliente hacia como debe de llegar a la base"
    public static Tipo_cuenta toEntity(TipoCuentaRequest request){

        Tipo_cuenta tc = new Tipo_cuenta();
        tc.setDescripcion(request.getDescripcion());
        tc.setSaldoMin(request.getSaldoMin());
        tc.setSaldoMax(request.getSaldoMax());
        tc.setFechaRegistro(LocalDate.now());
        return tc;
    }


    //De entity -> reponse
    //Como sale desde el servicio hacia el cliente


    public static TipoCuentaResponse toResponse(Tipo_cuenta cuenta){

        return new TipoCuentaResponse(cuenta.getTipoCuentaId(),
                cuenta.getDescripcion(),cuenta.getSaldoMin(),
                cuenta.getSaldoMax(),cuenta.getFechaRegistro());
    }

    //Actualizar datos dentro de un objeto entidad
    //"Reemplaza los datos viejos de una entidad por los nuevos extraidos del request"
    public static void updateEntity(Tipo_cuenta cuenta, TipoCuentaRequest request){
        cuenta.setTipoCuentaId(request.getTipoCuentaId());
        cuenta.setDescripcion(request.getDescripcion());
        cuenta.setSaldoMax(request.getSaldoMax());
        cuenta.setSaldoMin(request.getSaldoMin());
        cuenta.setFechaAct(LocalDate.now());

    }




}
