package com.example.exception;

public class InvalidFormatEmailException extends InvalidInputException {
    public InvalidFormatEmailException(String message) {
        super(message);
    }
}
