package com.ns_cuenta.logic;


import com.ns_cuenta.constants.Mensajes;
import com.ns_cuenta.dto.TipoCuentaRequest;
import com.ns_cuenta.dto.TipoCuentaResponse;
import com.ns_cuenta.entity.Tipo_cuenta;
import com.ns_cuenta.exception.BusinessException;
import com.ns_cuenta.mapper.TipoCuentaMapper;
import com.ns_cuenta.repository.AutoRepository;
import com.ns_cuenta.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Paso 5. Resuelvo la logica del negocio.
@Service
public class AutoLogic implements AutoService {

    //Se hace una inyeccion de dependencias
    @Autowired
    AutoRepository repo;


    @Override
    public TipoCuentaResponse guardar(TipoCuentaRequest request) {

        //Validaciones de negocio:Aquellas que validan cosas, condiciones muy particulares de la logica de negocio
        //


        if(repo.getCoundBySaldoMin(request.getSaldoMin())>=1000){
            throw new BusinessException(Mensajes.LIMITE_SALDOMIN);
        }else if(repo.getCountBySaldoMax(request.getSaldoMax())>=1000){
            throw new BusinessException (Mensajes.LIMITE_SALDOMAX);
        }else{
            //Objeto para guardar la info en base de datos
            Tipo_cuenta cuenta = TipoCuentaMapper.toEntity(request);
            repo.save(cuenta);

            return TipoCuentaMapper.toResponse(cuenta) ;  //El objeto debe reflejar el id y la fecha de registro otorgado por la base
        }
    }

    @Override
    public TipoCuentaResponse actualizar(TipoCuentaRequest request) {
        //Objeto para guardar la info en la base de datos
        Tipo_cuenta tc = repo.findById(request.getTipoCuentaId()).get();
        TipoCuentaMapper.updateEntity(tc,request);
        repo.save(tc); //Actualiza los datos en la base
        return TipoCuentaMapper.toResponse(tc); //El objeto debe reflejar el id y la fecha de actualizacion otorgado por la base
    }

    @Override
    public TipoCuentaResponse buscar(int id) {
       return TipoCuentaMapper.toResponse (repo.findById(id).get());
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List mostrar() {

        List<TipoCuentaResponse> lista = new ArrayList<TipoCuentaResponse>();
        for (Tipo_cuenta tc : repo.findAll()){
            lista.add(TipoCuentaMapper.toResponse(tc));
        }
        return lista;
    }

    @Override
    public List buscarPorSaldoMin(double saldoMin) {
        return repo.findbySaldoMin(saldoMin).get();


    }

    @Override
    public List buscarPorSaldoMax(double saldoMax) {
        return repo.findbySaldoMax(saldoMax).get();



    }

    @Override
    public List buscarPorDescripcion(String descripcion) {
        return repo.findbyDescripcion(descripcion).get();


    }
}
