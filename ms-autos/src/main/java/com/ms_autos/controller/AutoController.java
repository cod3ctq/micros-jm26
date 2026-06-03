package com.ms_autos.controller;

import com.ms_autos.dto.AutoRequest;
import com.ms_autos.dto.AutoResponse;
import com.ms_autos.entity.Autos;
import com.ms_autos.logic.AutoLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autos") //Nombre del recurso, mapeo a nivel de controlador
public class AutoController {
    @Autowired
    AutoLogic service;
    @GetMapping  //GET
    public ResponseEntity<List<Autos>> mostrar(){
        List<Autos> autos = service.mostrar();
        return new ResponseEntity<List<Autos>>(autos, HttpStatusCode.valueOf(200));
    }
    @PostMapping //POST
    public ResponseEntity<AutoResponse> guardar(@Valid @RequestBody AutoRequest request){
        AutoResponse a= service.guardar(request);
        return new ResponseEntity<AutoResponse>(a, HttpStatusCode.valueOf(200));
    }
    @PutMapping //PUT
    public ResponseEntity<AutoResponse> actualizar(@Valid @RequestBody AutoRequest request){
        AutoResponse a= service.actualizar(request);
        return new ResponseEntity<AutoResponse>(a, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<AutoResponse> buscar(@PathVariable int id){
        AutoResponse a= service.buscar(id);
        return new ResponseEntity<AutoResponse>(a, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/marca/{id}")
    public ResponseEntity<List<Autos>> buscarPorMarca(@PathVariable int id){
        List<Autos> autos = service.buscarPorMarca(id);
        return new ResponseEntity<List<Autos>>(autos, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/tipo/{descripcion}")
    public ResponseEntity<List<Autos>> buscarPorTipo(@PathVariable String descripcion){
        List<Autos> autos = service.buscarPorTipo(descripcion);
        return new ResponseEntity<List<Autos>>(autos, HttpStatusCode.valueOf(200));
    }
}
