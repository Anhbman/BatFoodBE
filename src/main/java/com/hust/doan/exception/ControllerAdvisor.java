package com.hust.doan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InputException.class)
    public ResponseEntity<Object> handleInputException (
            InputException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamps", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException (
            UserNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamps", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFound (
            UserNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamps", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserExitsException.class)
    public ResponseEntity<?> handleUserExits(UserExitsException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamps", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WebServiceException.class)
    public ResponseEntity<?> handleWebService(WebServiceException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamps", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
