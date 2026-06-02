package com.ms_cuentas.service;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuentas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CuentaService {

    CuentaResponse guardar(CuentaRequest request);
    CuentaResponse actualizar(CuentaRequest request);
    CuentaResponse buscar(int id);
    String eliminar(int id);

    List buscarPorCliente(int id);
    List buscarPorTipoCuenta(int id);

    List mostrar();

    CuentaResponse actualizarSaldo(CuentaRequest request);
    CuentaResponse actualizarStatus(CuentaRequest request);

}
