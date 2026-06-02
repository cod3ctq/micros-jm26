package com.ms_tarjetas.service;

import com.ms_tarjetas.dto.TarjetasRequest;
import com.ms_tarjetas.dto.TarjetasResponse;
import com.ms_tarjetas.entity.Tarjetas;

import java.util.List;

//4
// interface de negocio: Diselo las operaciones de negocio de las cuales este servicio se hara cargo
public interface TarjetasService {
    TarjetasResponse guardar(TarjetasRequest request);
    TarjetasResponse actualizar(TarjetasRequest request);
    TarjetasResponse buscar(int id);
    String eliminar(int id);
    List mostrar();//lista de todas

    List buscarNumTarjeta(String numer);
    List bucarporTipo(int tipo);

}
