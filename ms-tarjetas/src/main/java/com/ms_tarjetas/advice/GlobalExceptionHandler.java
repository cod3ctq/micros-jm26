package com.ms_tarjetas.advice;

//Controoldaor goblar de excepciones - mecanismo del framework
import com.ms_tarjetas.errors.ApiErrors;
import com.ms_tarjetas.exception.BusinessException;
import org.jspecify.annotations.Nullable;
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

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //Para generar el codigo: clic derecho->Generate-Overide-Methods
// cada uno de estos metodos interceptan las exepicones antes de que entre, cada uno de estos mensjaes se extraen
   // y se crea u obketo donde contiene la infomrmacion necesaria para, con l datos necesarios
     //       con los datos necesarios(/mensaje, code status http, timestamp)
    // evitanddi asi tasa de servidor y dificiles de entender
    @Override
    protected @Nullable ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Formatos no conciden");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("RequestBody is not readable");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Verbo HTTP no soportado por el método");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);

    }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("tipo de formato no soportado");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Manejo de variable faltante");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Parametor de peticion no encontrado");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<String> errors = new ArrayList<String>();

        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ApiErrors errores = new ApiErrors("Datos inválidos", errors, HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    //Con @ExceptionHandler puedo aregar mis propias excepciones personalizadas la manejador global
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }
}
