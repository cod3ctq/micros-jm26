package com.ms_empleados.service;

import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.dto.EmpleadoResponse;
import java.util.List;

// Capa 4: Interfaz de negocio, diseño de las operaciones de negocio de las cuales este servicio se hará cargo
public interface EmpleadoService {
    // Métodos abstractos, todos son publico por default
    // Las salidas de los métodos del servicio no deben ser Entidades de acuerdo a la arquitectura
    // Para eso se deberían usar DTOs, en este caso los Response son esos DTOs
    EmpleadoResponse guardar(EmpleadoRequest request); // Metodo que guardará un nuevo empleado y devolverá el Objeto que se acaba de guardar
    EmpleadoResponse actualizar(EmpleadoRequest request); // Metodo que actualizará un empleado y devolverá el Objeto que se acaba de actualizar
    EmpleadoResponse buscar(int id); // Metodo que buscará un empleado por el id y devolverá el Objeto que se encuentre
    String eliminar(int id); // Metodo que eliminará un empleado y devolverá un mensaje cuando lo haga

    List mostrar(); // Metodo que devolverá una Lista de todos los empleados
    List buscarPorRol(int id); // Metodo que devolverá una Lista de los empleados con cierto rol id
    List buscarPorStatus(String status); // Metodo que devolverá una Lista de todos los empleados con cierto status
}