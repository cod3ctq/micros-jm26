package com.ms_tarjetas.controller;

import com.ms_tarjetas.dto.TarjetasRequest;
import com.ms_tarjetas.dto.TarjetasResponse;
import com.ms_tarjetas.entity.Tarjetas;
import com.ms_tarjetas.logic.TarjetaLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarjetas")//Nombre del recurso, mapeo a nivel de controlador
public class TarjetasController {

    @Autowired
    TarjetaLogic service;

    @GetMapping
    public ResponseEntity<List<Tarjetas>> mostrar() {
        List<Tarjetas> tarjetas = service.mostrar();
        return new ResponseEntity<List<Tarjetas>>(tarjetas, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TarjetasResponse> guardar(@Valid @RequestBody TarjetasRequest request) {
        System.out.println("ENTRO AL CONTROLLER>>>>>> " + request);
        TarjetasResponse tarjeta = service.guardar(request);
        return new ResponseEntity<TarjetasResponse>(tarjeta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TarjetasResponse> buscar(@PathVariable int id) {
        TarjetasResponse t = service.buscar(id);
        return new ResponseEntity<TarjetasResponse>(t, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<TarjetasResponse> actualizar(@Valid @RequestBody TarjetasRequest request) {
        TarjetasResponse t = service.actualizar(request);
        return new ResponseEntity<TarjetasResponse>(t, HttpStatusCode.valueOf(200));

    }
}
