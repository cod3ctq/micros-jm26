package com.ms_empleados.advice;

import com.ms_empleados.errors.ApiErrors;
import com.ms_empleados.exception.BusinessException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Esta Clase será un controlador global de excepciones - mecanismo del framework
// Todos los métodos dentro de esta Clase están manejando todas las excepciones que podrían ocurrir
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // Para generar el código: clic derecho -> Generate -> Override Methods

    // Cada uno de estos métodos intercepta las excepciones antes de que lleguen al cliente
    // Dentro de cada metodo se extraen sólo los mensajes de la excepción...
    // ... y se crea un Objeto que contiene la información necesaria a transmitir (ApiErrors)...
    // ... con los datos necesarios (mensajes, code status http, timestamp)...
    // ... evitando así generar trazas de servidor muy grandes y difíciles de entender

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("Verbo HTTP no soportado por el método");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("MediaType no soportado");
        detalles.add(ex.getMessage());
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("Variable de URL no encontrada");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("Parámetro de peticion no encontrado");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ApiErrors errores = new ApiErrors("Datos inválidos", errors, HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("Formatos no coinciden");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<>();
        detalles.add("RequestBody is not readable");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    // Con @ExceptionHandler se pueden agregar nuestras propias excepciones personalizadas al manejador global
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }
}