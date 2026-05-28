package com.ms_autos.service;

import com.ms_autos.dto.AutoRequest;
import com.ms_autos.entity.Autos;

import java.util.List;

//4
//Interface de negocio: Diseño las operaciones de negocio de las cuales este servicio se hara cargo
public interface AutoService {

    Autos guardar(AutoRequest request);
    Autos actualizar(AutoRequest request);
    Autos buscar(int id);
    String eliminar(int id);


    List buscarPorMarca(int id);
    List buscarPorTipo(String tipo);





}
