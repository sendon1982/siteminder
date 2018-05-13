package com.mjiang.email.service.exception;

public class NoRunningEmailServerException extends RuntimeException {

    public NoRunningEmailServerException() {
        super();
    }

    public NoRunningEmailServerException(String message) {
        super(message);
    }

    public NoRunningEmailServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
