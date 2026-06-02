package com.ms_movimientos.mapper;


import com.ms_movimientos.dto.MovimientoRequest;
import com.ms_movimientos.dto.MovimientoResponse;
import com.ms_movimientos.entity.Movimientos;

//Clase que se en carga de transformar los objetos desde y hacia la forma deseada,
// ya sean entidades, request y response
public class MovimientoMapper {

    //De request -> entity
    //"como llega desde el cliente hacia como debe llegar a la base"

    public static Movimientos toEntity(MovimientoRequest request){


        Movimientos a = new Movimientos();
        a.setMovID(request.getMovID());
        a.setCuentaID(request.getCuentaID());
        a.setTipo(request.getTipo());
        a.setFechaOP(request.getFechaOP());
        a.setMonto(request.getMonto());

        return a;
    }

    //De entity -> response
    //como sale desde el servicio hacia la base

    public static MovimientoResponse toResponse(Movimientos movimiento){
        return new MovimientoResponse(movimiento.getTipo(),
                movimiento.getFechaOP(),
                movimiento.getMonto());


    }
    public static void updateEntity(Movimientos movimiento, MovimientoRequest request){
        movimiento.setCuentaID(request.getCuentaID());
        movimiento.setTipo(request.getTipo());
        movimiento.setFechaOP(request.getFechaOP());
        movimiento.setMonto(request.getMonto());

    }


}
