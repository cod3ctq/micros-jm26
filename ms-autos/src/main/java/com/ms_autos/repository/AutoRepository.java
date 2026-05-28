package com.ms_autos.repository;

import com.ms_autos.entity.Autos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// 2 - Crear el DAO
// DAO
@Repository // Establece la responsabilidad de las operaciones de acceso a datos (DAO)
public interface AutoRepository extends JpaRepository<Autos, Integer> {

    //Aqui ya existen las operaciones basicas resueltas
    //si necesito algo mas elaborado, tendre que resolverlo aqui, mediante JPQL - Consultas orientadas a objetos



}
