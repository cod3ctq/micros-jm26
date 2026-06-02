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

    @Query("SELECT t FROM Tarjetas t WHERE t.modelo =:modelo")
    Optional<List<Autos>> findByModelo(@Param("modelo") String modelo);

  ", modelo='" + modelo + '\'' +
            ", año=" + año +
            ", tipo='" + tipo + '\'' +
            ", marcaId=" + marcaId +
            '}';
}
