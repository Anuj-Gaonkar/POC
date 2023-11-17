package com.poc.spring.exception;

public class ModelAlreadyExistsException extends RuntimeException {

    public ModelAlreadyExistsException(String message) {
        super(message);
    }

    public ModelAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
