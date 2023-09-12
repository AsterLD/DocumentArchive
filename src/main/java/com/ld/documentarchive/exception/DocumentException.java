package com.ld.documentarchive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DocumentException extends RuntimeException {
    public DocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentException(String message) {
        super(message);
    }
}
