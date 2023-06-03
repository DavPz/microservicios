package com.msvc.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        Map map = new HashMap();
        map.put("message",resourceNotFoundException.getMessage());
        map.put("succes",false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }

}