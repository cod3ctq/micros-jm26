package com.ms_medios_pago.controller;


import com.ms_medios_pago.dto.MedioPagoRequest;
import com.ms_medios_pago.dto.MedioPagoResponse;
import com.ms_medios_pago.entity.Medios_pago;
import com.ms_medios_pago.logic.MedioPagoLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Medios_Pago", description = "Operaciones para gestion de medios_pago")
@RestController
@RequestMapping("api/v1/medios_pago") //nombre del recurso, mapeo a nivel de controlador
public class MedioPagoController {
    @Autowired
    MedioPagoLogic service;

    @Operation(summary = "Listar medios de pago",
    description = "Obtiene todos los medios de pago registrados")
    @GetMapping
    public ResponseEntity<List<Medios_pago>> mostrar(){
        List<Medios_pago> medios_pago = service.mostrar();
        return new ResponseEntity<List<Medios_pago>>(medios_pago, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Guardar medio de pago",
    description = "Registra un nuevo medio de pago usando un DTO de entrada")
    @PostMapping
    public ResponseEntity<MedioPagoResponse> guardar(@Valid @RequestBody MedioPagoRequest request){
        MedioPagoResponse mp = service.guardar(request);
        return new ResponseEntity<MedioPagoResponse>(mp, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Actualizar medio de pago",
    description = "Actualiza un medio de pago usando un DTO")
    @PutMapping
    public ResponseEntity<MedioPagoResponse> actualizar(@Valid @RequestBody MedioPagoRequest request){
        MedioPagoResponse mp = service.actualizar(request);
        return new ResponseEntity<MedioPagoResponse>(mp, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Buscar un medio de pago",
    description = "Obtiene los datos de un medio de pago mediante su ID")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<MedioPagoResponse> buscar(@PathVariable int id){
        MedioPagoResponse mp = service.buscar(id);
        return new ResponseEntity<MedioPagoResponse>(mp, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Eliminar un medio de pago",
    description = "Elimina un medio de pago mediante su ID")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Buscar por descripcion",
    description = "Obtiene los datos de un medio de pago por su descripcion")
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<List<Medios_pago>> buscarPorDescripcion(@PathVariable String descripcion){

        List<Medios_pago> medios_pago = service.buscarPorDescripcion(descripcion);
        return new ResponseEntity<List<Medios_pago>>(medios_pago, HttpStatusCode.valueOf(200));

    }


}
