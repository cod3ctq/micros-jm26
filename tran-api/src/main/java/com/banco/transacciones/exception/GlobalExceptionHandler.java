package com.banco.transacciones.exception;

import com.banco.transacciones.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFound(ResourceNotFoundException ex) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> business(BusinessException ex) {
        return build(HttpStatus.CONFLICT, ex.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> campos.put(error.getField(), error.getDefaultMessage()));
        return build(HttpStatus.BAD_REQUEST, "La petición contiene datos inválidos", campos);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generic(Exception ex) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno en transacciones-service", null);
    }

    private ResponseEntity<ErrorResponse> build(HttpStatus status, String mensaje, Map<String, String> campos) {
        return ResponseEntity.status(status).body(new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), mensaje, campos));
    }
}
