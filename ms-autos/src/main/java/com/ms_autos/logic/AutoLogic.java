package com.ms_autos.logic;


import com.ms_autos.dto.AutoRequest;
import com.ms_autos.entity.Autos;
import com.ms_autos.repository.AutoRepository;
import com.ms_autos.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//5 : Implementacion del contrato de acciones de negocio (4)
//Resuelvo la logica de negocio
@Service
public class AutoLogic implements AutoService {

    //Inyeccion de dependencias
    @Autowired
    AutoRepository repo;

    @Override
    public Autos guardar(AutoRequest request) {
        //Objeto para guardar la info en base de datos
        Autos a = new Autos();
        a.setAño(request.getAño());
        a.setModelo(request.getModelo());
        a.setMarcaId(request.getMarcaId());
        a.setTipo(request.getTipo());
        a.setFechaRegistro(LocalDate.now());
        repo.save(a); // Guarda, persiste los datos en la base, otorgandole un id
        return a; //Objeto debe reflejar el id otorgado por la base
    }

    @Override
    public Autos actualizar(AutoRequest request) {
        //Objeto para guardar la info en base de datos
        Autos a = repo.findById(request.getAutoId()).get(); //Objeto extraido con la informacion vieja
        a.setAño(request.getAño());
        a.setModelo(request.getModelo());
        a.setMarcaId(request.getMarcaId());
        a.setTipo(request.getTipo());
        a.setFechaRegistro(LocalDate.now());
        repo.save(a); // Guarda, persiste los datos en la base, otorgandole un id
        return a; //Objeto debe reflejar el id otorgado por la base
    }

    @Override
    public Autos buscar(int id) {
        return null;
    }

    @Override
    public String eliminar(int id) {
        return "";
    }

    @Override
    public List buscarPorMarca(int id) {
        return List.of();
    }

    @Override
    public List buscarPorTipo(String tipo) {
        return List.of();
    }
}
