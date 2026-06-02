package com.ms_cuentas.repository;

import com.ms_cuentas.entity.Cuentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuentas, Integer> {

    @Query("SELECT c FROM Cuentas c WHERE c.clienteId =:id")
    Optional<List<Cuentas>> findByClienteId(@Param("id")int id);

    @Query("SELECT c FROM Cuentas c WHERE c.tipoCuentaId =:id")
    Optional<List<Cuentas>> findByTipoCuentaId(@Param("id")int id);

    @Query("SELECT COUNT(c.clienteId) FROM Cuentas c WHERE c.clienteId =:id")
    Integer getCountByCliente(@Param("id")int id);
}
