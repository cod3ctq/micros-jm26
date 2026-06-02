package com.ms_movimientos.service;

import com.ms_movimientos.dto.MovimientoRequest;
import com.ms_movimientos.dto.MovimientoResponse;
import com.ms_movimientos.entity.Movimientos;

import java.util.Date;
import java.util.List;

public interface MovimientoService {

    MovimientoResponse guardar(MovimientoRequest request);
    MovimientoResponse actualizar(MovimientoRequest request);
    MovimientoResponse buscar(int id);
    String eliminar(int id);
    List mostrar();

    List buscarPorTipo(String tipo);
    List buscarPorFecha(Date fechaOp);

    //List buscarPorMonto(double monto);
}
