package com.ns_cuenta.service;

import com.ns_cuenta.dto.TipoCuentaRequest;
import com.ns_cuenta.dto.TipoCuentaResponse;
import com.ns_cuenta.entity.Tipo_cuenta;

import java.util.List;

//Hacer el autoservice: paso 4.
//Inteface de negocio: Diseño ls operaciones de negocio de las cuales este servicio se hara cargo
public interface AutoService {

    //Las salidas de los metodos del servicio no deben ser entidades
    //De acuerdo a la arquitectura, para eso se deberia de usar dtos
    //En este caso, los response serian esos dtos.

    TipoCuentaResponse guardar(TipoCuentaRequest request);
    TipoCuentaResponse actualizar(TipoCuentaRequest request);
    TipoCuentaResponse buscar(int id);
    String eliminar(int id);

    List mostrar ();
    List buscarPorSaldoMin (double saldoMin);
    List buscarPorSaldoMax (double saldoMax);
    List buscarPorDescripcion (String descripcion);





}
