package com.cliente.logic;

import com.cliente.constants.Mensajes;
import com.cliente.dto.ClienteRequest;
import com.cliente.dto.ClienteResponse;
import com.cliente.entity.Cliente;
import com.cliente.exception.BusinessException;
import com.cliente.mapper.ClienteMapper;
import com.cliente.repository.ClienteRepository;
import com.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Resuelvo la logica de negocio
@Service
public class ClienteLogic implements ClienteService {

    // Inyeccion de dependencias
    @Autowired
    ClienteRepository repo;

    @Override
    public ClienteResponse guardar(ClienteRequest request) {

        //Validaciones de negocio: Aquellas que validan cosas, condiciones muy particulares de la logica de negocio
        //1.Validar que no haya mas de 3 usuarios con el mismo correo
        int usosActuales = repo.contarClientesPorCorreo(request.getCorreo());

        Cliente cliente=null;
        if (usosActuales >= 3) {
            throw new BusinessException(Mensajes.LIMITE_CORREO);
        }else {

            // Objeto para guardar la info en base de datos
            cliente = ClienteMapper.toEntity(request);
            repo.save(cliente); // Guarda, persiste los datos en la base, otorgandole un id
        }
        return ClienteMapper.toResponse(cliente); // Objeto debe reflejar el id otorgado por la base
    }

    @Override
    public ClienteResponse actualizar(ClienteRequest request) {
        // Objeto extraido con la informacion vieja
        Cliente c = repo.findById(request.getClienteId()).get();
        ClienteMapper.updateEntity(c,request);
        repo.save(c);
        return ClienteMapper.toResponse(c);
    }

    @Override
    public ClienteResponse buscar(int id) {
        return ClienteMapper.toResponse(repo.findById(id).get()); //Asumo que siempre existira el objeto, asi que extraigo directo
        //con el .get
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Cliente eliminado";
    }

    @Override
    public List mostrar() {
        //Lista de objetos response que sera devuelta al final del metodo
        List<ClienteResponse> lista = new ArrayList<ClienteResponse>();
        //ciclo que itera sobre la lsita de entidades
        //a fin de extraer de cada objeto de entidad sus valores
        //y transformarlo a objetos response, Anadiendolo a la lista de response
        for(Cliente c : repo.findAll()){
            lista.add(ClienteMapper.toResponse(c));
        }
        return lista;
    }
}