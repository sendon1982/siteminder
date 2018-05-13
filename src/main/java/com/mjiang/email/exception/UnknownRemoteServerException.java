package com.mjiang.email.exception;

public class UnknownRemoteServerException extends  RuntimeException {

    public UnknownRemoteServerException() {
        super();
    }

    public UnknownRemoteServerException(String message) {
        super(message);
    }

    public UnknownRemoteServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
