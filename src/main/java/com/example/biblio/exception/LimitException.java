package com.example.biblio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LimitException extends RuntimeException {
	
	private String message;

    public LimitException() {}

    public LimitException(String msg) {
        super(msg);
        this.message = msg;
    }
	
}
