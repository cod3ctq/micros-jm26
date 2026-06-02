package com.ms_tipo_prestamo.logic;

import com.ms_tipo_prestamo.dto.TipoPrestamoRequest;
import com.ms_tipo_prestamo.dto.TipoPretamoResponse;
import com.ms_tipo_prestamo.entity.Tipo_Prestamo;
import com.ms_tipo_prestamo.mapper.TipoPrestamoMapper;
import com.ms_tipo_prestamo.repository.TipoPrestamoRepository;
import com.ms_tipo_prestamo.service.TipoPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoPrestamoLogic implements TipoPrestamoService {


    @Autowired
    TipoPrestamoRepository repo;


    @Override
    public TipoPretamoResponse guardar(TipoPrestamoRequest request) {


        Tipo_Prestamo tp2 = TipoPrestamoMapper.toEntity(request);
      repo.save(tp2);
      return TipoPrestamoMapper.toResponse(tp2);
    }





    @Override
    public TipoPretamoResponse actualizar(TipoPrestamoRequest request) {
        Tipo_Prestamo tp = repo.findById(request.getTipoPrestamoId()).get();
        TipoPrestamoMapper.updateEntity(tp, request);
        repo.save(tp);
        return TipoPrestamoMapper.toResponse(tp);
    }




    @Override
    public TipoPretamoResponse buscar(int id) {

        return TipoPrestamoMapper.toResponse(repo.findById(id).get());
    }


    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List mostrar() {

        List<TipoPretamoResponse> lista = new ArrayList<TipoPretamoResponse>();

        for (Tipo_Prestamo tp : repo.findAll()){
            lista.add(TipoPrestamoMapper.toResponse(tp));
        }

        return lista;
    }


    @Override
    public List buscarPorTipo(int id) {

        repo.findbyTIPO_PRESTAMO_ID(id).get();



        return List.of();
    }
}
