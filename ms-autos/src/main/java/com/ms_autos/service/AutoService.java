package com.ms_autos.service;

import com.ms_autos.dto.AutoRequest;
import com.ms_autos.dto.AutoResponse;
import com.ms_autos.entity.Autos;

import java.util.List;

//4
//Interface de negocio: Diseño las operaciones de negocio de las cuales este servicio se hara cargo
public interface AutoService {

    //Las salidas de los metodos del servicio no deben ser entidades
    //de acuerdo a la arquitectura, para eso se deberia usar dtos
    //en este caso, los response serian esos dtos
    AutoResponse guardar(AutoRequest request);
    AutoResponse actualizar(AutoRequest request);
    AutoResponse buscar(int id);
    String eliminar(int id);
    List mostrar(); //lista de todos


    List buscarPorMarca(int id);
    List buscarPorTipo(String tipo);





}
