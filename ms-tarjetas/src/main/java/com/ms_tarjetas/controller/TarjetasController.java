package com.ms_tarjetas.controller;

import com.ms_tarjetas.dto.TarjetasRequest;
import com.ms_tarjetas.dto.TarjetasResponse;
import com.ms_tarjetas.entity.Tarjetas;
import com.ms_tarjetas.logic.TarjetaLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="Tarjetas", description = "Operaciones para gestion de tarjetas")
@RestController
@RequestMapping("api/v1/tarjetas")//Nombre del recurso, mapeo a nivel de controlador
public class TarjetasController {

    @Autowired
    TarjetaLogic service;

    @Operation(
            summary = "ListaA todas las tarjetas",
            description = "obtiene los datos de las tarjetas"
    )
    @GetMapping
    public ResponseEntity<List<Tarjetas>> mostrar() {
        List<Tarjetas> tarjetas = service.mostrar();
        return new ResponseEntity<List<Tarjetas>>(tarjetas, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "Guardar Tarjeta",
            description ="Registra una nueva tarjeta usando un DTO de entrada"
            )
    @PostMapping
    public ResponseEntity<TarjetasResponse> guardar(@Valid @RequestBody TarjetasRequest request) {
        System.out.println("ENTRO AL CONTROLLER>>>>>> " + request);
        TarjetasResponse tarjeta = service.guardar(request);
        return new ResponseEntity<TarjetasResponse>(tarjeta, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "busca tarjetas",
            description = "obtiene los datos de las tarjetas por el id"
    )
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TarjetasResponse> buscar(@PathVariable int id) {
        TarjetasResponse t = service.buscar(id);
        return new ResponseEntity<TarjetasResponse>(t, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "elimina tarjetas",
            description = "elimina los datos de las tarjetas"
    )
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "actualiza tarjetas",
            description = "actualiza los datos de las tarjetas y los guarda"
    )
    @PutMapping
    public ResponseEntity<TarjetasResponse> actualizar(@Valid @RequestBody TarjetasRequest request) {
        TarjetasResponse t = service.actualizar(request);
        return new ResponseEntity<TarjetasResponse>(t, HttpStatusCode.valueOf(200));

    }
}
