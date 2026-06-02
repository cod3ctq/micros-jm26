package com.ms_medios_pago.logic;

import com.ms_medios_pago.constants.Mensajes;
import com.ms_medios_pago.dto.MedioPagoRequest;
import com.ms_medios_pago.dto.MedioPagoResponse;
import com.ms_medios_pago.entity.Medios_pago;
import com.ms_medios_pago.exception.BusinessException;
import com.ms_medios_pago.mapper.MedioPagoMapper;
import com.ms_medios_pago.repository.MedioPagoRepository;
import com.ms_medios_pago.service.MedioPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Capa 5. implementacion del contrato de acciones de negocio
@Service
public class MedioPagoLogic implements MedioPagoService {
    @Autowired
    MedioPagoRepository repo;


    @Override
    public MedioPagoResponse guardar(MedioPagoRequest request) {


        //VALIDACIONES DE NEGOCIO


        Medios_pago mp = null;

        //validar que no haya un registro con esa descripcion a guardar

        if(repo.getCountByDescription(request.getDescripcion())>=1){
            throw new BusinessException(Mensajes.DESCRIPCION_DUPLICADA);
        } else{
            //objeto para guardar la informacion en la bd

            mp = MedioPagoMapper.toEntity(request);

            repo.save(mp); //guarda los datos en la base, otorgandole un id

        }

        return MedioPagoMapper.toResponse(mp); //objeto debe reflejar el id otorgado por la base
    }

    @Override
    public MedioPagoResponse actualizar(MedioPagoRequest request) {

        //Objeto para guardar la informacion en bd
        Medios_pago mp = repo.findById(request.getMedioId()).get(); //objeto extraido con la informacion vieja

        MedioPagoMapper.updateEntity(mp, request);

        mp.setDescripcion(request.getDescripcion());

        repo.save(mp); //guarda los datos en la base, otorgandole un id

        return MedioPagoMapper.toResponse(mp); //objeto debe reflejar el id otorgado por la base

    }

    @Override
    public MedioPagoResponse buscar(int id) {
        return MedioPagoMapper.toResponse(repo.findById(id).get());
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Registro eliminado correctamente";
    }

    @Override
    public List mostrar() {

        //Lista de objetos response que sera devuelta al final del metodo
        List<MedioPagoResponse> lista = new ArrayList<MedioPagoResponse>();
        //ciclo que itera sobre la lista de entidades
        //a fin de extraer de cada objeto de entidad sus valores
        //y transformarlos a objetos response, aniadiendolos a la lista de response
        for(Medios_pago mp : repo.findAll()){
            lista.add(MedioPagoMapper.toResponse(mp));
        }
        return lista;
    }

    @Override
    public List buscarPorDescripcion(String descripcion) {

        return repo.findByDescripcion(descripcion).get();
    }
}
