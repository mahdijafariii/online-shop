package com.example.exception;

public class InvalidFormatPhoneNumberException extends InvalidInputException{
    public InvalidFormatPhoneNumberException(String message) {
        super(message);
    }
}
