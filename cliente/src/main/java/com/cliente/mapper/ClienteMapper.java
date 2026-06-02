package com.cliente.mapper;

import com.cliente.dto.ClienteRequest;
import com.cliente.dto.ClienteResponse;
import com.cliente.entity.Cliente;

//Clase que se encarga de transformar los objetos
// desde y hacia la forma deseada, ya sean entidades, request y response.
public class ClienteMapper {

    //de Request ---> Entity
    //"Como llega desde el cliente hacia como debe llegar a la base"
    public static Cliente toEntity(ClienteRequest request){
        Cliente c = new Cliente();

        c.setNombre(request.getNombre());
        c.setApP(request.getApP());
        c.setApM(request.getApM());
        c.setDireccion(request.getDireccion());
        c.setTelefono(request.getTelefono());
        c.setCorreo(request.getCorreo());
        c.setIne(request.getIne());
        c.setRfc(request.getRfc());
        c.setFechaNac(request.getFechaNac());
        return c;
    }

    //De entity ---> response
    //Como sale desde el servicio hacia el cliente

    public static ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(cliente.getNombre(),cliente.getApP(),
                cliente.getApM(),cliente.getFechaNac());
    }

    //Actualizar datos dentro de un objeto entidad
    //"Reemplaza los datos viejos de una entidad por los nuevos extraidos del request"
    //actua sobre el mismo objeto el updateEntity

    public static void updateEntity(Cliente cliente, ClienteRequest request){
        cliente.setNombre(request.getNombre());
        cliente.setApP(request.getApP());
        cliente.setApM(request.getApM());
        cliente.setFechaNac(request.getFechaNac());
    }

}
