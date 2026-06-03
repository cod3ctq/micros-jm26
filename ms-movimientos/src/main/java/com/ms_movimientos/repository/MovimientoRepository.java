package com.ms_movimientos.repository;

import com.ms_movimientos.entity.Movimientos;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimientos, Integer> {

    @Query("SELECT a FROM Movimientos a WHERE a.fechaOP =:fecha")
    Optional<List<Movimientos>>findByFechaOP(@Param("fecha") LocalDate fecha);


    @Query("SELECT a FROM Movimientos a WHERE a.tipo =:descripcion")
    Optional<List<Movimientos>>findByTipo(@Param("descripcion")String descripcion);

    @Query("SELECT COUNT(a.tipo) FROM Movimientos a WHERE a.tipo =:descripcion")
    Double getCountTipo(@Param("descripcion")String descripcion);

}
