package com.belong.exception;

public class PhoneNumberNotExistException extends RuntimeException {
    public PhoneNumberNotExistException(String message) {
        super(message);
    }
}
