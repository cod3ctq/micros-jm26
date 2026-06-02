package com.ms_movimientos.logic;

import com.ms_movimientos.Constants.Mensajes;
import com.ms_movimientos.dto.MovimientoRequest;
import com.ms_movimientos.dto.MovimientoResponse;
import com.ms_movimientos.entity.Movimientos;
import com.ms_movimientos.exception.BusinesException;
import com.ms_movimientos.mapper.MovimientoMapper;
import com.ms_movimientos.repository.MovimientoRepository;
import com.ms_movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovimientoLogic implements MovimientoService {

    //inyeccion de dependencias
    @Autowired
    MovimientoRepository repo;

    @Override
    public MovimientoResponse guardar(MovimientoRequest request) {

        Movimientos movimiento=null;

        if (repo.getCountTipo(request.getTipo())>=60){
        throw new BusinesException(Mensajes.LIMITE_SERVICIO);
        } else{
            movimiento = MovimientoMapper.toEntity(request);
            repo.save(movimiento); //guarda, persiste los datos en la base otrogandole un id.
        }
        return MovimientoMapper.toResponse(movimiento);//objeto debe reflejar el id otorgado por la base
    }

    @Override
    public MovimientoResponse actualizar(MovimientoRequest request) {
        Movimientos a= repo.findById(request.getMovID()).get();
        MovimientoMapper.updateEntity(a, request);
        repo.save(a);
        return MovimientoMapper.toResponse(a);
    }

    @Override
    public MovimientoResponse buscar(int id) {

        return MovimientoMapper.toResponse(repo.findById(id).get());//asumo que siempre existira el objeto, asi que extraigo directo con el .get()
    }

    @Override
    public String eliminar(int id) {

        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List mostrar() {

        List<MovimientoResponse> lista= new ArrayList<MovimientoResponse>();

        for (Movimientos a : repo.findAll()){
            lista.add(MovimientoMapper.toResponse(a));
        }
        return lista;
    }


    @Override
    public List buscarPorTipo(String tipo) {
        return repo.findByTipo(tipo).get();
    }

    @Override
    public List buscarPorFecha(Date fechaOp) {
        return repo.findByFechaOP(fechaOp).get();
    }

//    @Override
//    public List buscarPorMonto(double monto){
//        return repo.findByMonto(monto).get();
//    }

}
