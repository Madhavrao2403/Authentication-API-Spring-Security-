package com.mini.Authentication.exception;

import com.mini.Authentication.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Response> handleUsernameNotFoundException(UsernameNotFoundException e){
        Response response = new Response(404,e.getMessage(), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        Response response = new Response(401,"Invalid username and password", Instant.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
