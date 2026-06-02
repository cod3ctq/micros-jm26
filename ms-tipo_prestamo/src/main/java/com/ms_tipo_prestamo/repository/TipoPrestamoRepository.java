package com.ms_tipo_prestamo.repository;

import com.ms_tipo_prestamo.entity.Tipo_Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<Tipo_Prestamo, Integer> {

    @Query("SELECT tp FROM Tipo_Prestamo tp WHERE tp.tipoPrestamoId =:id")
        Optional<List<Tipo_Prestamo>> findbyTIPO_PRESTAMO_ID(@Param("id")int id);

    @Query("SELECT tp FROM Tipo_Prestamo tp WHERE tp.descripcion =:descripcion")
    Optional<List<Tipo_Prestamo>> findbyTIPO_PRESTAMO_ID(@Param("descripcion")String descripcion);

    @Query("SELECT tp FROM Tipo_Prestamo tp WHERE tp.plazo =:plazo")
    Optional<List<Tipo_Prestamo>> findbyTIPO_PRESTAMO_ID(@Param("plazo") double plazo);



}
