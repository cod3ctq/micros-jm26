package com.ms_empleados.logic;

import com.ms_empleados.constants.Mensajes;
import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.dto.EmpleadoResponse;
import com.ms_empleados.entity.Empleados;
import com.ms_empleados.exception.BusinessException;
import com.ms_empleados.mapper.EmpleadoMapper;
import com.ms_empleados.repository.EmpleadoRepository;
import com.ms_empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Asegurarnos que se importe desde esta librería, no hk2
import java.util.ArrayList;
import java.util.List;

// Capa 5: Implementación del contrato de acciones de negocio (capa 4)
// Resuelve la lógica de negocio
@Service // Anotación para que Spring administre la Clase y haga una instancia de ella
public class EmpleadoLogic implements EmpleadoService { // Implementamos interfaz EmpleaadoService e implementamos sus métodos
    @Autowired // Anotación para hacer una inyección de dependencias
    EmpleadoRepository repo; // Inyectamos un Objeto de tipo EmpleadoRepository para poder hacer uso de él desde esta Clase y comunicarnos con la db

    @Override
    public EmpleadoResponse guardar(EmpleadoRequest request) {
        // Validaciones de negocio: Aquellas que validan cosas, condiciones muy particulares de la lógica del negocio que se esté programando,
        // normalmente no hay alguna anotación que las implemente a exactitud
        Empleados e = null;
        // 1. Validar que no haya más de 3 empleados con el mismo rol
        if (repo.getCountByRol(request.getRolId()) >= 3) {
            throw new BusinessException(Mensajes.LIMITE_ROL); // Lanzamos excepción
            // Validar que no haya más de 3 empleados con el mismo apellido paterno
        } else if (repo.getCountByApellidoP(request.getApP()) >= 3) {
            throw new BusinessException(Mensajes.LIMITE_APELLIDO_P); // Lanzamos excepción
        } else {
            e = EmpleadoMapper.toEntity(request); // Objeto para guardar la info en la db
            repo.save(e); // Guarda, persiste los datos en la db, otorgándole un id. Se instancia un Objeto de EmpleadoRepository que se inyectó, con la variable repo
        }
        return EmpleadoMapper.toResponse(e); // Objeto debe reflejar el id y la fecha de registro otorgado por la base
    }

    @Override
    public EmpleadoResponse actualizar(EmpleadoRequest request) {
        Empleados e = repo.findById(request.getEmpleadoId()).get(); // Extraemos del envoltorio Optional el Objeto de la entidad usando el id del Objeto Request
        EmpleadoMapper.updateEntity(e, request); // Invocamos al metodo para actualizar el Objeto y pasamos argumentos necesarios
        repo.save(e); // Guarda, actualiza los datos en la db conservando el mismo id
        return EmpleadoMapper.toResponse(e); // Objeto debe reflejar el id y la fecha de actualización otorgado por la base
    }

    @Override
    public EmpleadoResponse buscar(int id) {
        return EmpleadoMapper.toResponse(repo.findById(id).get()); // Asumimos que siempre existirá el Objeto, así que lo extraímos con el .get() del Optional
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Empleado eliminado";
    }

    @Override
    public List<EmpleadoResponse> mostrar() {
        List<EmpleadoResponse> lista = new ArrayList<>(); // Lista que devolverá este metodo
        // Ciclo que itera sobre la lista de Entidades con el fin de extraer de cada Objeto de Entidad sus valores y transformarlos a Objetos Response
        for (Empleados e : repo.findAll()) { // Por cada Objeto entidad de la Lista en el repositorio (findAll() devuelve una Lista)
            lista.add(EmpleadoMapper.toResponse(e)); // Convertimos cada Objeto de Entidad a Response que se va iterando y se añade a la Lista de Objetos Response
        }
        return lista; // Retornamos la Lista con los Objetos Response
    }

    @Override
    public List<Empleados> buscarPorRol(int id) {
        return repo.findByRolId(id).get(); // De no encontrar nada devuelve una lista vacía, ya que estamos trabajando con un Optional
    }

    @Override
    public List<Empleados> buscarPorStatus(String status) {
        return repo.findByStatus(status).get(); // De no encontrar nada devuelve una lista vacía, ya que estamos trabajando con un Optional
    }
}