package com.tiagoperroni.main.exceptionhandler;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ProductErrorHandler extends RuntimeException{
        private static final Long serialVersionUID = 1L;

    public ProductErrorHandler(String message) {
        super(message);
    }

    public ProductErrorHandler(String message, Throwable cause) {
        super(message, cause);
    }

}
