package com.ms_cuentas.logic;

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuentas;
import com.ms_cuentas.exception.BussinessException;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.repository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaLogic implements CuentaService {

    @Autowired
    CuentaRepository repo;

    @Override
    public CuentaResponse guardar(CuentaRequest request) {
        Cuentas cuenta = null;

        //Validar que un cliente no pueda tener mas de 6 cuentas
        if(repo.getCountByCliente(request.getClienteId())>=5){
            throw new BussinessException(Mensajes.LIMITE_CLIENTES);
        } else {
            //Objeto para guardar la informacion en la base de datos
            cuenta = CuentaMapper.toEntity(request);
            repo.save(cuenta);
        }
        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public CuentaResponse actualizar(CuentaRequest request) {
        Cuentas c = repo.findById(request.getCuentaId()).get();
        CuentaMapper.updateEntity(c, request);
        repo.save(c);
        return CuentaMapper.toResponse(c);
    }

    @Override
    public CuentaResponse buscar(int id) {
        return CuentaMapper.toResponse(repo.findById(id).get());
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List<Cuentas> buscarPorCliente(int id) {
        return repo.findByClienteId(id).get();
    }

    @Override
    public List buscarPorTipoCuenta(int id) {
        return repo.findByTipoCuentaId(id).get();
    }

    @Override
    public List mostrar() {
        List<CuentaResponse> list = new ArrayList<CuentaResponse>();

        for (Cuentas c : repo.findAll()){
            list.add(CuentaMapper.toResponse(c));
        }
        return list;
    }

    @Override
    public CuentaResponse actualizarSaldo(CuentaRequest request) {
        Cuentas cuenta = repo.findById(request.getCuentaId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // Actualizar saldo
        cuenta.setSaldo(request.getSaldo());

        // Actualizar fecha_actualizada
        cuenta.setFechaAc(LocalDate.now());

        // Guardar cambios
        repo.save(cuenta);

        // Devolver respuesta
        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public CuentaResponse actualizarStatus(CuentaRequest request) {
        // Buscar la cuenta
        Cuentas cuenta = repo.findById(request.getCuentaId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // Actualizar status
        cuenta.setStatus(request.getStatus());

        // Actualizar fecha_actualizada
        cuenta.setFechaAc(LocalDate.now());

        // Guardar cambios
        repo.save(cuenta);

        // Devolver respuesta
        return CuentaMapper.toResponse(cuenta);
    }
}
