package com.ms_empleados.repository;

import com.ms_empleados.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// Capa 2: DAO
// Indicamos que este Interfaz hereda de otra Interfaz y los tipos de dato con los que trabajará (Objeto identity y el tipo de dato de la PK
@Repository // Establece la responsabilidad de las operaciones de accedo a datos (DAO)
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {
    // Aquí ya existen las operaciones básicas resueltas
    // Si se necesita algo más elaborado se tendrá que resolver aquí mediante JPQL - Consultas orientadas a Objetos, no a las tablas
    // JPQL: Java Persistance Query Languaje

    // Hacemos una búsqueda por un atributo que no es la llave primaria
    // @Query sirve para desarrollar en lenguaje JPQL la consulta personalizada que necesitemos
    @Query("SELECT e FROM Empleados e WHERE e.rolId = :id") // Hacemos la consulta orientada a los Objetos, no a las tablas
    // e = variable de Objeto de tipo Empleados (entity)
    Optional<List<Empleados>> findByRolId(@Param("id")int id); // @Param("id") para decirle que en el ":id" dentro del @Query ponga lo que estamos pasando como parámetro

    @Query("SELECT e FROM Empleados e WHERE e.status = :descripcion") // Los dos puntos : son importantes porque en Spring Data JPA los parámetros deben llevar :
    Optional<List<Empleados>> findByStatus(@Param("descripcion")String descripcion); // @Param: conecta el parámetro de Java con el parámetro de la consulta
    // Devolverá un Optional con una Lista dentro con Objetos de tipo Empleados (Entity)

    // Consulta: Cuántos empleados existen con ese mismo rol
    @Query("SELECT COUNT(e.rolId) FROM Empleados e WHERE e.rolId = :rol")
    Integer getCountByRol(@Param("rol") int rol);

    @Query("SELECT COUNT(e.apP) FROM Empleados e WHERE e.apP = :apellido")
    Integer getCountByApellidoP(@Param("apellido") String apellido);
}