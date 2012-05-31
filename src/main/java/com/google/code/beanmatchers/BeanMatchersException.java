package com.google.code.beanmatchers;

public class BeanMatchersException extends RuntimeException {

    public BeanMatchersException(String message) {
        super(message);
    }

    public BeanMatchersException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanMatchersException(Throwable cause) {
        super(cause);
    }
}
