package com.group.artifact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionCustom extends RuntimeException {

    public NotFoundExceptionCustom() {
        super();
    }

    public NotFoundExceptionCustom(String message) {
        super(message);
    }

    public NotFoundExceptionCustom(String message, Throwable cause) {
        super(message, cause);
    }
}
