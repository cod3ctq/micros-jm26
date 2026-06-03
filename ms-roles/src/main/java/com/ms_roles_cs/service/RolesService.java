package com.ms_roles_cs.service;

import com.ms_roles_cs.dto.RolesRequest;
import com.ms_roles_cs.dto.RolesResponse;
import com.ms_roles_cs.entity.Roles;
import java.util.List;

//4
//Interface de negocio: Diseña las operaciones de negocio de las cuales este servicio se hara cargo
public interface RolesService {
    //Las salidas de los metodos del servicio no deben de ser entidades
    //De acuerdo a la arquitectura para eso se deberia usar dtos
    //En este caso los response serian esos dtos
    RolesResponse guardar(RolesRequest request);
    RolesResponse actualizar(Integer rolId, RolesRequest request);
    RolesResponse buscar(Integer rolId);
    void eliminar(Integer rolId);
    List mostrar(); //lista de todos


    List buscarPorDescripcion(String descripcion);

}