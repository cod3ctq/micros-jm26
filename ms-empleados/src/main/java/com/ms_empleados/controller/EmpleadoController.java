package com.ms_empleados.controller;

import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.dto.EmpleadoResponse;
import com.ms_empleados.entity.Empleados;
import com.ms_empleados.logic.EmpleadoLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Empleados", description = "Operaciones para gestión de empleados") // Se utiliza para documentar endpoints de API REST en la interfaz de Swagger UI
@RestController // Marca la Clase como controlador REST, para crear APIs REST, sirve para indicar que se van a recibir peticiones HTTP, puede devolver datos de tipo JSON
@RequestMapping("api/v1/empleados") // Nombre del recurso, mapeo a nivel de controlador
public class EmpleadoController {
    @Autowired // Anotación para hacer una inyección de dependencias
    EmpleadoLogic service; // Inyectamos un Objeto de tipo EmpleadoLogic para poder hacer uso de él

    @Operation(summary = "Listar empleados", description = "Obtiene todos los empleados registrados") // Se utiliza para documentar un endpoint específico de API REST
    @GetMapping // Verbo "get" en el URL, llega aquí
    // ResponseEntity: Clase de Spring que se usa en APIs REST para construir respuestas HTTP desde un controlador
    public ResponseEntity<List<EmpleadoResponse>> mostrar() {
        List<EmpleadoResponse> empleados = service.mostrar(); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<List<EmpleadoResponse>>(empleados, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Guardar empleado", description = "Registra un nuevo empleado usando un DTO de entrada")
    @PostMapping // Verbo "post" en el URL, llega aquí
    // @Valid para indicar al controlador que active las validaciones que agregamos en la Clase Request
    // @RequestBody para poder manipular/extraer los datos del DTO contenidos en el cuerpo de la petición
    public ResponseEntity<EmpleadoResponse> guardar(@Valid @RequestBody EmpleadoRequest request) {
        EmpleadoResponse e = service.guardar(request); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<EmpleadoResponse>(e, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Actualizar empleado", description = "Sobreescribe los datos del empleado usando un DTO de entrada")
    @PutMapping // Verbo "put" en el URL, llega aquí
    // @Valid para indicar al controlador que active las validaciones que agregamos en la Clase Request
    public ResponseEntity<EmpleadoResponse> actualizar(@Valid @RequestBody EmpleadoRequest request) {
        EmpleadoResponse e = service.actualizar(request); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<EmpleadoResponse>(e, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Buscar un empleado", description = "Obtiene los datos de un empleado buscando por id")
    @GetMapping("/buscar/{id}") // Verbo "get" en el URL, pero con end point modificado, llega aquí
    // @PathVariable para decirle que utilice como parámetro el valor que viene entre {llaves} en el URL
    public ResponseEntity<EmpleadoResponse> buscar(@PathVariable int id) {
        EmpleadoResponse e = service.buscar(id); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<EmpleadoResponse>(e, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Eliminar un empleado", description = "Borra los datos de un empleado buscando por id")
    @DeleteMapping("/eliminar/{id}") // Verbo "delete" en el URL, pero con end point modificado, llega aquí
    // @PathVariable para decirle que utilice como parámetro el valor que viene entre {llaves} en el URL
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Buscar empleados por rol", description = "Obtiene una lista de empleados filtrando por rolId")
    @GetMapping("/rol/{id}") // Verbo "get" en el URL, pero con end point modificado, llega aquí
    public ResponseEntity<List<Empleados>> buscarPorRol(@PathVariable int id) { // @PathVariable para que utilice como parámetro el valor que viene entre llaves en el URL
        List<Empleados> empleados = service.buscarPorRol(id); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<List<Empleados>>(empleados, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Buscar empleados por status", description = "Obtiene una lista de empleados filtrando por status")
    @GetMapping("/status/{descripcion}") // Verbo "get" en el URL, pero con end point modificado, llega aquí
    public ResponseEntity<List<Empleados>> buscarPorStatus(@PathVariable String descripcion) { // @PathVariable para usar como parámetro el valor en las llaves en el URL
        List<Empleados> empleados = service.buscarPorStatus(descripcion); // Se instancia un Objeto de la Clase EmpleadoLogic que se inyectó, al usar la variable service
        return new ResponseEntity<List<Empleados>>(empleados, HttpStatusCode.valueOf(200));
    }
}