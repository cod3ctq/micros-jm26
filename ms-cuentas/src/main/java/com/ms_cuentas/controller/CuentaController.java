package com.ms_cuentas.controller;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuentas;
import com.ms_cuentas.logic.CuentaLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cuentas", description = "Operaciones para gestion de cuentas")
@RestController
@RequestMapping("api/v1/cuentas")
public class CuentaController {

    @Autowired
    CuentaLogic service;

    @Operation(
        summary = "Listar cuentas",
        description = "Obtiene los datos de tabla cuentas"
    )
    @GetMapping
    public ResponseEntity<List<Cuentas>> mostrar(){
        List<Cuentas> cuentas = service.mostrar();
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));
    }
    @Operation(
            summary = "Guardar cuentas",
            description = "Guarda los datos de tabla cuentas"
    )
    @PostMapping
    public ResponseEntity<CuentaResponse> guardar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse c = service.guardar(request);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }
    @Operation(
            summary = "Actualizar cuenta",
            description = "Actualiza los datos de tabla cuentas"
    )
    @PutMapping
    public ResponseEntity<CuentaResponse> actualizar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse c = service.actualizar(request);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "Busca cuenta",
            description = "Busca una cuenta de la tabla cuentas"
    )
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CuentaResponse> buscar(@PathVariable int id){
        CuentaResponse c = service.buscar(id);
        return new ResponseEntity<CuentaResponse>(c, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "Elimina cuenta",
            description = "Elimina una cuenta"
    )
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
    /// ////////////Aqui correguir los de abajo

    @Operation(
            summary = "Buscar cuentas por cliente ID",
            description = "List a"
    )
    @GetMapping("/cliente/{id}")
    ResponseEntity<List<Cuentas>> buscarPorClienteId(@PathVariable int id){
        List<Cuentas> cuentas = service.buscarPorCliente(id);
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));

    }

    @Operation(
            summary = "Lista cuentas por Tipo",
            description = "Lista "
    )
    @GetMapping("/tipoCuenta/{id}")
    ResponseEntity<List<Cuentas>> buscarPorTipoCuentaId(@PathVariable int id){
        List<Cuentas> cuentas = service.buscarPorTipoCuenta(id);
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatusCode.valueOf(200));
    }


    @Operation(
            summary = "Actualizar cuenta",
            description = "Actuliza los datos de tabla cuentas"
    )
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

    @Operation(
            summary = "Actualizar cuenta",
            description = "Actuliza los datos de tabla cuentas"
    )
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
