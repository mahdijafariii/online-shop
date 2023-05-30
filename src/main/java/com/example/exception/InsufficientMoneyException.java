package com.example.exception;

public class InsufficientMoneyException extends InvalidPurchaseException{

    public InsufficientMoneyException(String message) {
        super(message);
    }
}
