package com.ms_empleados.mapper;

import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.dto.EmpleadoResponse;
import com.ms_empleados.entity.Empleados;
import java.time.LocalDate;

// Clase que se encarga de transformar los Objetos desde y hacia la forma deseada, ya sean entidades, requests o response
public class EmpleadoMapper {

    // Convertimos Request -> Entity
    // Como llega desde el cliente
    public static Empleados toEntity(EmpleadoRequest request) {
        Empleados e = new Empleados(); // Objeto para guardar la info en la db
        // Asignamos valores
        e.setRolId(request.getRolId());
        e.setNombre(request.getNombre());
        e.setApP(request.getApP());
        e.setApM(request.getApM());
        e.setFechaIn(LocalDate.now());
        e.setCorreo(request.getCorreo());
        e.setTel(request.getTel());
        e.setStatus(request.getStatus());
        return e; // Retornamos el Objeto
    }

    // Convertimos Entity -> Response
    // Como sale desde el servicio al cliente
    public static EmpleadoResponse toResponse(Empleados empleado) {
        return new EmpleadoResponse(empleado.getNombre(), empleado.getApP(),
                empleado.getApM(), empleado.getFechaIn());
    }

    // Actualizamos Objeto de Identidad Empleados con base en el Objeto Request que recibimos del cliente
    public static void updateEntity(Empleados empleado, EmpleadoRequest request) {
        // Asignamos los nuevos valores
        empleado.setRolId(request.getRolId());
        empleado.setNombre(request.getNombre());
        empleado.setApP(request.getApP());
        empleado.setApM(request.getApM());
        empleado.setCorreo(request.getCorreo());
        empleado.setTel(request.getTel());
        empleado.setStatus(request.getStatus());
    }
}