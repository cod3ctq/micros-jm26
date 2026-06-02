package com.ms_empleados.exception;

// Esta Exception representa cualquier excepción que desee propagar en una validación de negocio, o sea esta englobará a todas
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}