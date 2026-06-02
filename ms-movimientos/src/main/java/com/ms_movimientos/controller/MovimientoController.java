package com.ms_movimientos.controller;

import com.ms_movimientos.dto.MovimientoRequest;
import com.ms_movimientos.dto.MovimientoResponse;
import com.ms_movimientos.entity.Movimientos;
import com.ms_movimientos.logic.MovimientoLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/v1/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoLogic service;
    @GetMapping
    public ResponseEntity<List<Movimientos>> mostrar(){
        List<Movimientos> movimientos = service.mostrar();
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));

    }
    @PostMapping
    public ResponseEntity<MovimientoResponse>guardar(@Valid @RequestBody MovimientoRequest request){
        MovimientoResponse a= service.guardar(request);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<MovimientoResponse>actualizar(@Valid @RequestBody MovimientoRequest request){
        MovimientoResponse a=service.actualizar(request);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{Id}")
    public ResponseEntity<MovimientoResponse>buscar(@PathVariable int Id){
        MovimientoResponse a=service.buscar(Id);
        return new ResponseEntity<MovimientoResponse>(a, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/eliminar/{Id}")
    public ResponseEntity<String>eliminar(@PathVariable int Id){
        String mensaje =service.eliminar(Id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/fechaOp/{fecha}")
    public ResponseEntity<List<Movimientos>> BuscarPorFecha(@PathVariable Date fecha){
        List<Movimientos> movimientos = service.buscarPorFecha(fecha);
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));
    }


    @GetMapping("/tipo/{descripcion}")
    public ResponseEntity<List<Movimientos>> BuscarPorTipo(@PathVariable String descripcion){
        List<Movimientos> movimientos = service.buscarPorTipo(descripcion);
        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));
    }

//    @GetMapping("/monto/{monto}")
//    public ResponseEntity<List<Movimientos>> BuscarPorMonto(@PathVariable double monto){
//        List<Movimientos> movimientos = service.buscarPorMonto(monto);
//        return new ResponseEntity<List<Movimientos>>(movimientos, HttpStatusCode.valueOf(200));
//    }
}
