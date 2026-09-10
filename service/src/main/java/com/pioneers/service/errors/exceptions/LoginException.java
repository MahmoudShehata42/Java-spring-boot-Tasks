package com.pioneers.service.errors.exceptions;

public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
