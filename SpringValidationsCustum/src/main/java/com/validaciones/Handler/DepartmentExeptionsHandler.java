package com.validaciones.Handler;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DepartmentExeptionsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }

    @ExceptionHandler(NullPointerException.class)
    public Map<String, String> handleNullArguments(NullPointerException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Error interno del servidor");
        errors.put("cause", "NullPointerException");

        // Obtener el nombre de los argumentos que son nulos
        StringBuilder detailsBuilder = new StringBuilder();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().startsWith("com.validaciones.DTO")) {
                detailsBuilder.append(stackTraceElement.getMethodName()).append(" es nulo;");
            }
        }
        String details = detailsBuilder.toString();
        errors.put("details", details);

        return errors;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Error interno del servidor");
        errors.put("cause", "HttpMessageNotReadableException");
        errors.put("details", "No se pudo leer el cuerpo de la solicitud");

        return errors;
    }
}
