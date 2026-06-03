package com.ns_cuenta.exception;


//Esta clase representa cualquier excepcion que desee propagar en una validacion de negocio. 
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
