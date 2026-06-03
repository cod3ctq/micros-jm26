package com.ms_roles_cs.logic;


import com.ms_roles_cs.constants.Mensajes;
import com.ms_roles_cs.dto.RolesRequest;
import com.ms_roles_cs.dto.RolesResponse;
import com.ms_roles_cs.entity.Roles;
import com.ms_roles_cs.exception.BusinessException;
import com.ms_roles_cs.mapper.RolesMapper;
import com.ms_roles_cs.repository.RolesRepository;
import com.ms_roles_cs.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Paso cinco, implementacion del contrato de acciones de negocio (paso cuatro)
//Resuelvo la logica de negocio
@Service
public class RolesLogic implements RolesService {

    //Inyeccion de dependencias por atributo
    @Autowired
    RolesRepository repo;

    @Override
    public RolesResponse guardar(RolesRequest request) {
        //Validaciones de negocio: Aquellas que validan cosas, condiciones muy particulares de la logica de negocio
        //que se este programando, normalmente no hay alguna anotacion que la implemente con exactitud
        Roles rol = null;
        //1.- Validar que no haya mas de 5 registros por rol con la misma descripcion
        if (repo.getCountByDescripcion(request.getDescripcion()) >= 5) {
            // Se utiliza throw en lugar de System.out.println porque throw detiene la ejecución
            // y evita que el registro se guarde en la base de datos. Un println solo muestra
            // un mensaje en consola, pero el programa continúa ejecutándose.
            throw new BusinessException(Mensajes.LIMITE_ROLES);
            //2.-Validar que no haya el mismo rol con el mismo sueldo mas de 5 veces
        } else if(repo.getCountBySueldo(request.getSueldo()) >= 5){
            throw new BusinessException(Mensajes.LIMITE_SUELDO);
        } else {
            //Objeto para guardar la info en base de datos
            rol = RolesMapper.toEntity(request);
            repo.save(rol);//Guarda el objeto y al guardarlo persiste los datos en la base, otorgandole un id
        }
        return RolesMapper.toResponse(rol);//El objeto debe reflejar el id otorgado por la base
    }

    @Override
    public RolesResponse actualizar(Integer rolId, RolesRequest request) {
        //Objeto para guardar la info en base de datos
        Roles rol = repo.findById(rolId).get(); //Objeto extraido con la informacion vieja
        RolesMapper.updateEntity(rol,request);
        repo.save(rol); //Actualiza, los datos en la base
        return RolesMapper.toResponse(rol); //Objeto para reflejar el id y fecha de actualizacion otorgado por la base
    }
    @Override
    public List mostrar(){
        //Lista de objetos response que sera devuelta al final del metodo
        List<RolesResponse> lista = new ArrayList<RolesResponse>();
        //Ciclo que itera sobre la lista de entidades
        //A fin de extraer de cada objeto de identidad sus valores y trasnformarlo a objetos response
        //aagregando listas de response
        for (Roles rol : repo.findAll()){
            lista.add(RolesMapper.toResponse(rol));

        }
        return lista;
    }
    @Override
    public RolesResponse buscar(Integer rolId) {
        return RolesMapper.toResponse(repo.findById(rolId).get());
    }

    @Override
    public void eliminar(Integer rolId) {
        repo.deleteById(rolId);
    }

    @Override
    public List<Roles> buscarPorDescripcion(String descripcion) {
        return repo.findByDescripcion(descripcion).get();
    }

}
