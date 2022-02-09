package com.epam.hospital.exception;

public class SeviceException extends RuntimeException {
    public SeviceException(String message) {
        super(message);
    }

    public SeviceException(String message, Throwable cause) {
        super(message, cause);
    }
}
