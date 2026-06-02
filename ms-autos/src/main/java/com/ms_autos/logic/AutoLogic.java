package com.ms_autos.logic;


import com.ms_autos.constants.Mensajes;
import com.ms_autos.dto.AutoRequest;
import com.ms_autos.dto.AutoResponse;
import com.ms_autos.entity.Autos;
import com.ms_autos.exception.BusinessException;
import com.ms_autos.mapper.AutoMapper;
import com.ms_autos.repository.AutoRepository;
import com.ms_autos.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//5 : Implementacion del contrato de acciones de negocio (4)
//Resuelvo la logica de negocio
@Service
public class AutoLogic implements AutoService {

    //Inyeccion de dependencias
    @Autowired
    AutoRepository repo;

    @Override
    public AutoResponse guardar(AutoRequest request) {

        //Validaciones de negocio : Aquellas que validan cosas, condiciones muy particulares de la logica de negocio
        // que se este programando, normalmente no hay alguna anotacion que las implemente a exactitud
        Autos auto=null;
        // 1: Validar que no haya mas de 3 autos con el mismo modelo
        if(repo.getCountByModel(request.getModelo())>=3){
            throw new BusinessException(Mensajes.LIMITE_MODELO); //lanzar excep despues
            //2 : Validar que no haya mas de 5 autos de la misma marca
        }else if(repo.getCountByMarca(request.getMarcaId())>=5){
            throw new BusinessException(Mensajes.LIMITE_MARCA);
        }else{
            //Objeto para guardar la info en base de datos
            auto = AutoMapper.toEntity(request);
            repo.save(auto); // Guarda, persiste los datos en la base, otorgandole un id
        }
        return AutoMapper.toResponse(auto); //Objeto debe reflejar el id y la fecha de registro otorgado por la base
    }

    @Override
    public AutoResponse actualizar(AutoRequest request) {
        //Objeto para guardar la info en base de datos
        Autos a = repo.findById(request.getAutoId()).get(); //Objeto extraido con la informacion vieja
        AutoMapper.updateEntity(a,request);
        repo.save(a); // Actualiza, los datos en la base
        return AutoMapper.toResponse(a); //Objeto debe reflejar el id y la fecha de actualizacion otorgado por la base
    }

    @Override
    public AutoResponse buscar(int id) {
        return AutoMapper.toResponse(repo.findById(id).get()); //Asumo que siempre existira el objeto, asi que extraigo directo con el .get()
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List mostrar() {
        //Lista de objetos response que sera devuelta al final del metodo
        List<AutoResponse> lista = new ArrayList<AutoResponse>();
        //ciclo que itera sobre la lista de entidades
        //a fin de extraer de cada objeto de entidad sus valores
        //y tranformarlo a objetos response, añadiendolos a la lista
        //de response
        for(Autos a : repo.findAll()){
            lista.add(AutoMapper.toResponse(a));
        }
        return lista;
    }

    @Override
    public List buscarPorMarca(int id) {
        return repo.findByMarcaId(id).get();
    }

    @Override
    public List buscarPorTipo(String tipo) {
        return repo.findByTipo(tipo).get();
    }
}
