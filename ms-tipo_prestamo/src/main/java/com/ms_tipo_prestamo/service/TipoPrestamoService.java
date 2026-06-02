package com.ms_tipo_prestamo.service;

import com.ms_tipo_prestamo.dto.TipoPrestamoRequest;
import com.ms_tipo_prestamo.dto.TipoPretamoResponse;
import com.ms_tipo_prestamo.entity.Tipo_Prestamo;

import java.util.List;

public interface TipoPrestamoService {


    TipoPretamoResponse guardar(TipoPrestamoRequest request);
    TipoPretamoResponse actualizar(TipoPrestamoRequest request);
    TipoPretamoResponse buscar(int id);
    String eliminar(int id);
    List mostrar();

    List buscarPorTipo(int id);







}
