package com.ms_medios_pago.repository;

import com.ms_medios_pago.entity.Medios_pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//2. DAO
@Repository //establece la responsabilidad de las operaciones de acceso a datos (dao)
public interface MedioPagoRepository extends JpaRepository<Medios_pago,Integer>{
    //mp
    //aqui ya existen las operaciones basicas resueltas
    //si necesito operaciones mas personalizadas aqui las desarrollare
    @Query("SELECT mp FROM Medios_pago mp WHERE mp.descripcion =:descripcion")
        Optional <List<Medios_pago>> findByDescripcion(@Param("descripcion")String descripcion);

    @Query("SELECT COUNT(mp.medioId) FROM Medios_pago mp WHERE mp.descripcion =:descripcion")
        Integer getCountByDescription(@Param("descripcion") String descripcion);
}
