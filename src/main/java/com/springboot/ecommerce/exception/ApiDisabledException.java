package com.springboot.ecommerce.exception;

public class ApiDisabledException extends RuntimeException {

    public ApiDisabledException(String message) {
        super(message);
    }

}
