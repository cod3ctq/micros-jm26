package com.ms_cuentas.mapper;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuentas;

import java.time.LocalDate;

public class CuentaMapper {

    public static Cuentas toEntity(CuentaRequest request){
        Cuentas c = new Cuentas();
        c.setClienteId(request.getClienteId());
        c.setTipoCuentaId(request.getTipoCuentaId());
        c.setNumCuenta(request.getNumCuenta());
        c.setClabe(request.getClabe());
        c.setSaldo(request.getSaldo());
        c.setFechaAp(LocalDate.now());
        c.setStatus(request.getStatus());
        c.setFechaAc(LocalDate.now());
        return c;
    }

    public static CuentaResponse toResponse(Cuentas cuenta){
        return new CuentaResponse(cuenta.getTipoCuentaId(),
                                    cuenta.getNumCuenta(),
                                    cuenta.getClabe(),
                                    cuenta.getSaldo(),
                                    cuenta.getFechaAp(),
                                    cuenta.getFechaAc());
    }

    public static void updateEntity(Cuentas c, CuentaRequest request){
        c.setClienteId(request.getClienteId());
        c.setTipoCuentaId(request.getTipoCuentaId());
        c.setNumCuenta(request.getNumCuenta());
        c.setClabe(request.getClabe());
        c.setSaldo(request.getSaldo());
        c.setFechaAp(LocalDate.now());//Checar esto
        c.setStatus(request.getStatus());
    }



}
