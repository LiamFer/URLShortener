package com.liamfer.urlShortener;

import com.liamfer.urlShortener.DTO.apiError;
import com.liamfer.urlShortener.exceptions.ResourceNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<apiError<String>> resourceNotFoundHandler(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new apiError<>(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<apiError<List<String>>> validationHandler(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new apiError<>(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .collect(Collectors.toList())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<apiError<String>> defaultExceptionHandler(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new apiError<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

}
