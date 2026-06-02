package com.ms_movimientos.exception;

    //esta clase representa cualquier excepcion que desee propagar en una validacion de negocio
public class BusinesException extends RuntimeException {
    public BusinesException(String message) {
        super(message);
    }
}
