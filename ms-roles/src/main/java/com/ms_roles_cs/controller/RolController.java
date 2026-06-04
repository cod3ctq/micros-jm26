package com.ms_roles_cs.controller;


import com.ms_roles_cs.dto.RolesRequest;
import com.ms_roles_cs.dto.RolesResponse;
import com.ms_roles_cs.entity.Roles;
import com.ms_roles_cs.logic.RolesLogic;
import com.ms_roles_cs.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Roles", description = "Operaciones para gestión de roles")
@RestController
@RequestMapping("api/v1/roles") //Nombre del recurso, mapeo a nivel de controlador
public class RolController {
    @Autowired
    RolesService service;

    @Operation(summary = "Listar roles", description = "Obtiene todos los roles registrados")
    @GetMapping
    public ResponseEntity<List<RolesResponse>> mostrar(){
        List<RolesResponse> roles = service.mostrar();
        return new ResponseEntity<List<RolesResponse>>(roles, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Guardar rol", description = "Registra un nuevo rol usando un DTO de entrada")
    @PostMapping
    public ResponseEntity<RolesResponse> guardar(@Valid @RequestBody RolesRequest request){
        RolesResponse rol = service.guardar(request);
        return new ResponseEntity<RolesResponse>(rol, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Actualizar rol", description = "Actualiza la información de un rol existente usando un DTO de entrada")
    @PutMapping
    public ResponseEntity<RolesResponse> actualizar(@Valid @RequestBody RolesRequest request){
        RolesResponse rol = service.actualizar(request.getRolId(), request);
        return new ResponseEntity<RolesResponse>(rol, HttpStatusCode.valueOf(200));
    }
    @Operation(summary = "Buscar rol por ID", description = "Obtiene la información de un rol a partir de su identificador")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<RolesResponse> buscar(@PathVariable int id){
        RolesResponse rol = service.buscar(id);
        return new ResponseEntity<RolesResponse>(rol, HttpStatusCode.valueOf(200));
    }
    //Tiene la misma accion que la del profesor la unica diferencia es la capa en donde se construye el mensaje, profesor en service y el mio en controlador
    @Operation(summary = "Eliminar rol", description = "Elimina un rol existente mediante su identificador")
    @DeleteMapping("eliminar/{id}") //Como el metodo devuelve void, no existe ninguna variable mensaje que guardar, por eso el cambio de codigo
    public ResponseEntity<String> eliminar(@PathVariable int id){
        service.eliminar(id);
        return new ResponseEntity<String>("Rol eliminado correctamente", HttpStatusCode.valueOf(200));
    }
    //Remplaza los metodos BuscarPorDescripcion y BuscarPorMarca, porque no tenemos nada de esto en nuestra base de datos.
    @Operation(summary = "Buscar roles por descripción", description = "Obtiene los roles cuya descripción coincide con el valor proporcionado")
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<List<Roles>> buscarPorDescripcion(@PathVariable String descripcion){
        List<Roles> roles = service.buscarPorDescripcion(descripcion);
        return new ResponseEntity<List<Roles>>(roles, HttpStatusCode.valueOf(200));
    }


}
