package com.ns_cuenta.controller;

import com.ns_cuenta.dto.TipoCuentaRequest;
import com.ns_cuenta.dto.TipoCuentaResponse;
import com.ns_cuenta.entity.Tipo_cuenta;
import com.ns_cuenta.logic.AutoLogic;
import com.ns_cuenta.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Tipo_Cuenta", description = "Operaciones para gestion de cuentas")
@RestController
@RequestMapping("api/v1/Tipo_cuenta")
public class TipoCuentaController {


    @Autowired
    AutoLogic service;

    @Operation(
            summary = "Listar cuentas",
            description = "Obtiene todas las cuentas registradas")
    @GetMapping
    public ResponseEntity<List<Tipo_cuenta>> mostrar(){
        List<Tipo_cuenta> tipo_cuentas = service.mostrar();
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));

    }
    @Operation(
            summary = "Guardar cuentas",
            description = "Registra una nueva Cuenta usando un DTO de entrada")
    @PostMapping
    public ResponseEntity<TipoCuentaResponse> guardar(@Valid @RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tc = service.guardar(request);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));

    }
    @Operation(
            summary = "Actualizar cuenta",
            description = "Registra una nueva Cuenta usando un DTO de entrada")
    @PutMapping
    public ResponseEntity<TipoCuentaResponse> actualizar(@Valid @RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tc = service.actualizar(request);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));

    }
    @Operation(
            summary = "Buscar cuenta",
            description = "Obtiene los datos de una cuenta buscando por id")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoCuentaResponse> buscar(@PathVariable int id){
        TipoCuentaResponse tc = service.buscar(id);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));


    }
    @Operation(
            summary = "Eliminar una cuenta",
            description = "Borra los datos de una cuenta por id")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje  = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));


    }
    @Operation(
            summary = "Buscar cuentas por saldo Minimo",
            description = "Obtiene una lista de cuentas filtrado por saldo Minimo")
    @GetMapping("/buscarPorSaldoMin/{saldoMin}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoMin(@PathVariable double saldoMin){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorSaldoMin(saldoMin);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }
    @Operation(
            summary = "Buscar cuentas por saldo Maximo",
            description = "Obtiene una lista de cuentas filtrado por saldo Maximo")
    @GetMapping("/buscarPorSaldoMax/{saldoMax}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoMax(@PathVariable double saldoMax){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorSaldoMax(saldoMax);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }
    @Operation(
            summary = "Buscar cuentas por descripcion",
            description = "Obtiene una lista de cuentas filtrado por descripcion")
    @GetMapping("/buscarPorDescripcion/{descripcion}")
    public ResponseEntity<List<Tipo_cuenta>> buscarporSaldoDescripcion(@PathVariable String descripcion){
        List<Tipo_cuenta> tipo_cuentas =  service.buscarPorDescripcion(descripcion);
        return new ResponseEntity<List<Tipo_cuenta>>(tipo_cuentas, HttpStatusCode.valueOf(200));


    }


}
