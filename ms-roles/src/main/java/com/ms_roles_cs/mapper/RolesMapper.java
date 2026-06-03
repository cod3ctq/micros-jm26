package com.ms_roles_cs.mapper;

import com.ms_roles_cs.dto.RolesRequest;
import com.ms_roles_cs.dto.RolesResponse;
import com.ms_roles_cs.entity.Roles;

//Se encarga de transformar los objetos desde y hacia la forma deseada, ya sean entidades, request y response
public class RolesMapper {
    //De request -> entity
    //Como llega desde el cliente hacia como debe llegar a la base
    public static Roles toEntity(RolesRequest request) {
        Roles rol = new Roles();
        rol.setDescripcion(request.getDescripcion());
        rol.setSueldo(request.getSueldo());
        return rol;
    }
    //De entity -> response
    //Como sale desde el servicio hacia el cliente
    public static RolesResponse toResponse (Roles rol){
        return new RolesResponse(
                rol.getRolId(),
                rol.getDescripcion(),
                rol.getSueldo());
    }
    //Actualizar datos dentro de un objeto de entidad
    //Remplaza los datos viejos de una entidad por los nuevos extraidos del request
    public static void updateEntity(Roles rol, RolesRequest request){
        rol.setDescripcion(request.getDescripcion());
        rol.setSueldo(request.getSueldo());
    }
}
