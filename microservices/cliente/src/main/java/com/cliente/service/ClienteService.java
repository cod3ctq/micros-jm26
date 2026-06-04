package com.cliente.service;

import com.cliente.dto.ClienteRequest;
import com.cliente.dto.ClienteResponse;
import com.cliente.entity.Cliente;

import java.util.List;

// Interface de negocio: Diseño las operaciones de negocio de las cuales este servicio se hara cargo
public interface ClienteService {

    //Las salidas de los metodos del servicio no deben ser entidades
    //De acuerdo a la arquitectura para eso se deberia usar DTOs
    //En este caso, los response serian esos DTOs

    ClienteResponse guardar(ClienteRequest request);
    ClienteResponse actualizar(ClienteRequest request);
    ClienteResponse buscar(int id);
    String eliminar(int id);
    List mostrar();
}