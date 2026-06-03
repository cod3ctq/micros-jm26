package com.ms_roles_cs.repository;

import com.ms_roles_cs.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Paso dos, crear el DAO
//DAO
@Repository //Establece la responsabilidad de las operaciones de acceso a datos (DAO)
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    //Aqui ya existen las operaciones basicas resueltas
    //Si necesito algo mas elaborado, tendre que resolverlo aqui, mediante JPQL - Consultas orientadas a objetos

    //@Query sirve para desarrollar en el lenguaje JPQL la consulta personalizada que necesitemos
    @Query("SELECT rol FROM Roles rol WHERE rol.descripcion =:descripcion")
    Optional<List<Roles>> findByDescripcion(@Param("descripcion")String descripcion);

    //Consulta: contar cuántos registros existen con la misma descripción.
    //Se utiliza para limitar la cantidad de roles repetidos permitidos.
    @Query("SELECT COUNT(rol.rolId) FROM Roles rol WHERE rol.descripcion = :descripcion")
    Integer getCountByDescripcion(@Param("descripcion") String descripcion);

    // Consulta: buscar cuántos roles existen con el mismo sueldo
    @Query("SELECT COUNT(rol.rolId) FROM Roles rol WHERE rol.sueldo = :sueldo")
    Integer getCountBySueldo(@Param("sueldo") Double sueldo);

}

