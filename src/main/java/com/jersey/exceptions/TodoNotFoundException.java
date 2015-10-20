package com.jersey.exceptions;

/**
 * @author SLA
 * @version 1.0
 */
public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super();
    }

    public TodoNotFoundException(String msg) {
        super(msg);
    }
}
