package com.ms_medios_pago.service;

import com.ms_medios_pago.dto.MedioPagoRequest;
import com.ms_medios_pago.dto.MedioPagoResponse;
import com.ms_medios_pago.entity.Medios_pago;

import java.util.List;

//capa 4
//interface de negocio: disenia las operaciones de negocio de las cuales este servicio se encarga
public interface MedioPagoService {
    MedioPagoResponse guardar(MedioPagoRequest request);
    MedioPagoResponse actualizar(MedioPagoRequest request);
    MedioPagoResponse buscar(int id);
    String eliminar(int id);
    List mostrar(); //lista de todos

    List buscarPorDescripcion(String descripcion);
}
