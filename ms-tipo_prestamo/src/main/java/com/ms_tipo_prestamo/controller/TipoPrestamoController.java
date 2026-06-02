package com.ms_tipo_prestamo.controller;

import com.ms_tipo_prestamo.dto.TipoPrestamoRequest;
import com.ms_tipo_prestamo.dto.TipoPretamoResponse;
import com.ms_tipo_prestamo.entity.Tipo_Prestamo;
import com.ms_tipo_prestamo.logic.TipoPrestamoLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Tipo_Prestamo")
public class TipoPrestamoController {
    @Autowired
    TipoPrestamoLogic service;
    @GetMapping
    public ResponseEntity<List<Tipo_Prestamo>> mostrar(){
        List<Tipo_Prestamo> tipo = service.mostrar();
        return new ResponseEntity<List<Tipo_Prestamo>>(tipo, HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<TipoPretamoResponse> guardar(@Valid @RequestBody TipoPrestamoRequest request){
        TipoPretamoResponse tp = service.guardar(request);
        return new ResponseEntity<TipoPretamoResponse>(tp,HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<TipoPretamoResponse>actualizar(@Valid @RequestBody TipoPrestamoRequest request){
        TipoPretamoResponse tp = service.actualizar(request);
        return new ResponseEntity<TipoPretamoResponse>(tp, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoPretamoResponse>buscar(@PathVariable int id){
        TipoPretamoResponse tp = service.buscar(id);
        return new ResponseEntity<TipoPretamoResponse>(tp,HttpStatusCode.valueOf(200));
    }


}
