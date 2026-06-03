package com.ns_cuenta.controller;

import com.ns_cuenta.dto.TipoCuentaRequest;
import com.ns_cuenta.dto.TipoCuentaResponse;
import com.ns_cuenta.entity.Tipo_cuenta;
import com.ns_cuenta.logic.AutoLogic;
import com.ns_cuenta.service.AutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Tipo_cuenta")
public class TipoCuentaController {


    @Autowired
    AutoLogic service;
    @GetMapping
    public ResponseEntity<List<Tipo_cuenta>> mostrar(){
        List<Tipo_cuenta> tipo_cuentas = service.mostrar();
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));

    }

    @PostMapping
    public ResponseEntity<TipoCuentaResponse> guardar(@Valid @RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tc = service.guardar(request);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));

    }
    @PutMapping
    public ResponseEntity<TipoCuentaResponse> actualizar(@Valid @RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tc = service.actualizar(request);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));

    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoCuentaResponse> buscar(@PathVariable int id){
        TipoCuentaResponse tc = service.buscar(id);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));


    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje  = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));


    }
    @GetMapping("/buscarPorSaldoMin/{saldoMin}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoMin(@PathVariable double saldoMin){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorSaldoMin(saldoMin);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }
    @GetMapping("/buscarPorSaldoMax/{saldoMax}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoMax(@PathVariable double saldoMax){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorSaldoMax(saldoMax);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }
    @GetMapping("/buscarPorDescripcion/{descripcion}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoDescripcion(@PathVariable String descripcion){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorDescripcion(descripcion);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }


}
