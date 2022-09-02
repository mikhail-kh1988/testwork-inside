package com.inside.exception;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExprException extends ExpiredJwtException {
    public ExprException(Header header, Claims claims, String message) {
        super(header, claims, message);
    }

    public ExprException(){
        super(null, null, null);
    }
}
