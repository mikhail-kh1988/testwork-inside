package com.inside.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OtherException extends Exception{
    public OtherException(String message) {
        super(message);
    }

    public OtherException(){
        super("Другая ошибка");
    }
}
