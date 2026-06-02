package com.ms_cuentas.controller;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuentas;
import com.ms_cuentas.logic.CuentaLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas")
public class CuentaController {

    @Autowired
    CuentaLogic service;

    @GetMapping
    public ResponseEntity<List<Cuentas>> mostrar(){
        List<Cuentas> cuentas = service.mostrar();
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<CuentaResponse> guardar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse c = service.guardar(request);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<CuentaResponse> actualizar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse c = service.actualizar(request);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CuentaResponse> buscar(@PathVariable int id){
        CuentaResponse c = service.buscar(id);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/cliente/{id}")
    ResponseEntity<List<Cuentas>> buscarPorClienteId(@PathVariable int id){
        List<Cuentas> cuentas = service.buscarPorCliente(id);
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));

    }

    @GetMapping("/tipoCuenta/{id}")
    ResponseEntity<List<Cuentas>> buscarPorTipoCuentaId(@PathVariable int id){
        List<Cuentas> cuentas = service.buscarPorTipoCuenta(id);
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));
    }


    @PatchMapping("/{id}/saldo/{nuevoSaldo}")
    public ResponseEntity<CuentaResponse> actualizarSaldo(
            @PathVariable int id,
            @PathVariable double nuevoSaldo) {

        CuentaRequest request = new CuentaRequest();
        request.setCuentaId(id);
        request.setSaldo(nuevoSaldo);

        CuentaResponse response = service.actualizarSaldo(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/{id}/status/{nuevoStatus}")
    public ResponseEntity<CuentaResponse> actualizarStatus(
            @PathVariable int id,
            @PathVariable String nuevoStatus) {

        CuentaRequest request = new CuentaRequest();
        request.setCuentaId(id);
        request.setStatus(nuevoStatus);

        CuentaResponse response = service.actualizarStatus(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}
