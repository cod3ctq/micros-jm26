package com.ms_movimientos.controller;

import com.ms_movimientos.dto.MovimientoRequest;
import com.ms_movimientos.dto.MovimientoResponse;
import com.ms_movimientos.entity.Movimientos;
import com.ms_movimientos.logic.MovimientoLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Tag(name = "Movimientos", description = "Operaciones para gestiones de Movimientos")
@RestController
@RequestMapping("api/v1/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoLogic service;

    @Operation(summary = "Listar movimientos", description = "Obtiene todos los movimientos registrados")
    @GetMapping
    public ResponseEntity<List<Movimientos>> mostrar(){
        List<Movimientos> movimientos = service.mostrar();
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));

    }

    @Operation(summary = "Guardar movimiento", description = "Registra un nuevo  movimiento usando un DTO de entrada")
    @PostMapping
    public ResponseEntity<MovimientoResponse>guardar(@Valid @RequestBody MovimientoRequest request){
        MovimientoResponse a= service.guardar(request);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Actualizar movimiento", description = "Sobreescribe los datos del movimiento usando un DTO de entrada")
    @PutMapping
    public ResponseEntity<MovimientoResponse>actualizar(@Valid @RequestBody MovimientoRequest request){
        MovimientoResponse a=service.actualizar(request);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Buscar un movimiento", description = "Obtiene los datos de un movimiento por Id")
    @GetMapping("/buscar/{Id}")
    public ResponseEntity<MovimientoResponse>buscar(@PathVariable int Id){
        MovimientoResponse a=service.buscar(Id);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Eliminar movimiento", description = "Borra los datos de un movimiento por Id")
    @DeleteMapping("/eliminar/{Id}")
    public ResponseEntity<String>eliminar(@PathVariable int Id){
        String mensaje =service.eliminar(Id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Busca un  movimiento por fecha", description = "Obtiene una lista de movimientos filtrando por fecha")
    @GetMapping("/fechaOp")
    public ResponseEntity<List<Movimientos>> BuscarPorFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        List<Movimientos> movimientos = service.buscarPorFecha(fecha);
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Busca un movimiento por tipo", description = "Obtiene una lista de movimientos filtando por tipo")
    @GetMapping("/tipo/{descripcion}")
    public ResponseEntity<List<Movimientos>> BuscarPorTipo(@PathVariable String descripcion){
        List<Movimientos> movimientos = service.buscarPorTipo(descripcion);
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));
    }

}
