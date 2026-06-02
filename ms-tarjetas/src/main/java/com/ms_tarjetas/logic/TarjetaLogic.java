package com.ms_tarjetas.logic;

import com.ms_tarjetas.constantes.Mensajes;
import com.ms_tarjetas.dto.TarjetasRequest;
import com.ms_tarjetas.dto.TarjetasResponse;
import com.ms_tarjetas.entity.Tarjetas;
import com.ms_tarjetas.exception.BusinessException;
import com.ms_tarjetas.mapper.TarjetasMapper;
import com.ms_tarjetas.repository.TarjetasRepository;
import com.ms_tarjetas.service.TarjetasService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


//5 Implementaciom del contrato de acciones de negocio (4)
// Resuekvo la logica de negocio
@Service
public class TarjetaLogic implements TarjetasService {

    @Autowired
     TarjetasRepository repo;

    @Override
    public TarjetasResponse guardar(TarjetasRequest request) {

        Tarjetas tarjeta =null;
//        System.out.println("ENTRO AL SERVICE >>>>>>"+request);
//        System.out.println("ANTES DEL REPOSITORY >>>>>>");
        if (!request.getNumTarjeta().matches("\\d{16}")) {
            throw new BusinessException(Mensajes.INVALID_SIZE_NUMBER);
//        } else if (){
//            throw new BusinessException("El numero de tarjeta ya ha sido registrado");
//
        } else {
            tarjeta=TarjetasMapper.toEntity(request);
            repo.save(tarjeta);
        }
        return TarjetasMapper.toResponse(tarjeta);

    }

    @Override
    public TarjetasResponse actualizar(TarjetasRequest request) {
        Tarjetas t = repo.findById(request.getTarjetaId()).get();
        TarjetasMapper.updateEntity(t,request);
        repo.save(t); // actualiza en BD
        return TarjetasMapper.toResponse(t);
    }

    @Override
    public TarjetasResponse buscar(int id) {

        return TarjetasMapper.toResponse(repo.findById(id).get());
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List mostrar() {
        // Lista de objetos response que sera devuelta al final del metodo
        List<TarjetasResponse> lista =new ArrayList<TarjetasResponse>();
        //ciclo que itera sobre la lista de entidades
        // a fin de extraer de cada objeti de entidad sus valores
        // y transformaro a objetos response, añadiendolos a la lista de response
        for (Tarjetas t : repo.findAll()){
            lista.add(TarjetasMapper.toResponse(t));

        }
        return lista;
    }

    @Override
    public List buscarNumTarjeta(String numer) {
        return repo.findByNumTarjeta(numer).get();
    }

    @Override
    public List bucarporTipo(int tipo) {
        return repo.findByTipoTarjeta(tipo).get();
    }


}
