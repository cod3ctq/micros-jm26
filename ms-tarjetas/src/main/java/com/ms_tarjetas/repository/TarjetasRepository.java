package com.ms_tarjetas.repository;

import com.ms_tarjetas.entity.Tarjetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//2 - Crear el DAO
@Repository// estbalece la responsablilidad de las operaciones de acceso a datos (DAO)
public interface TarjetasRepository extends JpaRepository<Tarjetas, Integer> {

    // AQUI YA EXISTEN LAS OPERACIONES BASICAS RESUELTAS
    // SI NECESITO ALGO MAS ELABORADO TENDRE QUE RESOLVERLO AQUI, MEDIANTE JPQL - CONSULTAS ORIENTADAS A OBJETOS

//    @Query("SELECT t FROM Tarjetas t WHERE t.=:fecha")
//            Optional<List<Tarjetas>>findByFechaVen(@Param("fecha")String fecha);
//
//    @Query("SELECT t FROM Tarjetas t WHERE t.nip=:nip")
//            Optional<List<Tarjetas>>findByNip(@Param("nip")String nip);

    @Query("SELECT t FROM Tarjetas t WHERE t.numTarjeta=:numer")
    Optional<List<Tarjetas>>findByNumTarjeta(@Param("numer") String numer);

    @Query("SELECT t FROM Tarjetas t WHERE t.tipoTarjeta=:tipo")
    Optional<List<Tarjetas>>findByTipoTarjeta(@Param("tipo")int tipo);

    String getTarjetasByNumTarjeta(String numTarjeta);

    //@Query("SELECT FROM TARJETAS"

}
