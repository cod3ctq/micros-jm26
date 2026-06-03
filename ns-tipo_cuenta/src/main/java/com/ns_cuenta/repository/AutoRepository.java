package com.ns_cuenta.repository;


import com.ns_cuenta.entity.Tipo_cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Este seria el paso numero 2: La creacion del DAO.
//Esta es la interfaz del DAO.
@Repository
public interface AutoRepository extends JpaRepository<Tipo_cuenta, Integer> {


    //Aqui ya existen las operaciones basicas resueltas,
    //Si necesito algo mas elaborado, tengo que usar el jpl.

    //Sirve para desarrollar el lenguaje JPQL la consulta personalizada que necesitamos
    @Query("SELECT tc FROM Tipo_cuenta tc WHERE tc.saldoMin = :SaldoMin") //Aqui debo cambiar el "id"
    Optional<List<Tipo_cuenta>> findbySaldoMin(@Param("SaldoMin")double SaldoMin); //Aqui debo cambiar el "id"

    @Query("SELECT tc FROM Tipo_cuenta tc WHERE tc.descripcion = :descripcion") //Aqui debo cambiar el "id"
    Optional<List<Tipo_cuenta>> findbyDescripcion(@Param("descripcion")String descripcion); //Aqui debo cambiar el "id"

    @Query("SELECT tc FROM Tipo_cuenta tc WHERE tc.saldoMax = :SaldoMax") //Aqui debo cambiar el "id"
    Optional<List<Tipo_cuenta>> findbySaldoMax(@Param("SaldoMax")double SaldoMax); //Aqui debo cambiar el "id"

    //Consulta: Cuantas cuentas existen con saldoMin de 1000
    @Query("SELECT COUNT(tc.tipoCuentaId) FROM Tipo_cuenta tc WHERE tc.saldoMin =:saldoMin")
    Integer getCoundBySaldoMin(@Param("saldoMin")double saldoMin);

    @Query("SELECT COUNT(tc.tipoCuentaId) FROM Tipo_cuenta tc WHERE tc.saldoMax =:saldoMax")
    Integer getCountBySaldoMax(@Param("saldoMax")double saldoMax);



    //Agregar los demas query que faltan clase autologic e interface de autorepository


}
