package com.cliente.controller;

import com.cliente.dto.ClienteRequest;
import com.cliente.dto.ClienteResponse;
import com.cliente.entity.Cliente;
import com.cliente.logic.ClienteLogic;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")//Nombre del recurso, mapeo a nivel de controlador
public class ClienteController {
    @Autowired
    ClienteLogic service;
    @GetMapping
    public ResponseEntity<List<Cliente>> mostrar(){
    List<Cliente> cliente = service.mostrar();
    return new ResponseEntity<List<Cliente>>(cliente, HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<ClienteResponse> guardar(@Valid @RequestBody ClienteRequest request){
        ClienteResponse c = service.guardar(request);
        return new ResponseEntity<ClienteResponse>(c,HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<ClienteResponse> actualizar(@Valid @RequestBody ClienteRequest request){
        ClienteResponse c = service.actualizar(request);
        return new ResponseEntity<ClienteResponse>(c, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable int id){
        ClienteResponse c = service.buscar(id);
        return new ResponseEntity<ClienteResponse>(c, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje,HttpStatusCode.valueOf(200));
    }
}
