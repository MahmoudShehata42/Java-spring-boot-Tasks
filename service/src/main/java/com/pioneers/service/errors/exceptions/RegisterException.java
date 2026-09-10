package com.pioneers.service.errors.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class RegisterException extends RuntimeException {

    public RegisterException(String message, String logMessage) {
        super(message);

        log.error(logMessage);
    }
}
