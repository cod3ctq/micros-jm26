package com.ms_autos.repository;

import com.ms_autos.entity.Autos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// 2 - Crear el DAO
// DAO
@Repository // Establece la responsabilidad de las operaciones de acceso a datos (DAO)
public interface AutoRepository extends JpaRepository<Autos, Integer> {

    //Aqui ya existen las operaciones basicas resueltas
    //si necesito algo mas elaborado, tendre que resolverlo aqui, mediante JPQL - Consultas orientadas a objetos

    //@Query sirve para desarrollar en lenguaje JPQL la consulta personalizada que necesitemos
    @Query("SELECT a FROM Autos a WHERE a.marcaId =:id")
    Optional<List<Autos>> findByMarcaId(@Param("id")int id);

    @Query("SELECT a FROM Autos a WHERE a.tipo =:descripcion")
    Optional<List<Autos>> findByTipo(@Param("descripcion")String descripcion);

    //consulta: buscar cuantos autos existen con ese mismo modelo
    @Query("SELECT COUNT(a.autoId) FROM Autos a WHERE a.modelo =:modelo")
    Integer getCountByModel(@Param("modelo") String modelo);

    @Query("SELECT COUNT(a.autoId) FROM Autos a WHERE a.marcaId =:marca")
    Integer getCountByMarca(@Param("marca") int marca);

}
