package com.inside.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionMessage> handleException(){
        return new ResponseEntity<>(new ExceptionMessage("Токен не валиден!"), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ExpiredJwtException.class)
    protected ResponseEntity<ExceptionMessage> handleExpiredJwtException(){
        return new ResponseEntity<>(new ExceptionMessage("Токен просрочен!"), HttpStatus.BAD_REQUEST);

    }

    @Data
    @AllArgsConstructor
    private static class ExceptionMessage{
        private String error;
    }

}
