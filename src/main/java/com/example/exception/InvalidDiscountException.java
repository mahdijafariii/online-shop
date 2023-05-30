package com.example.exception;

public class InvalidDiscountException extends Exception{
    public InvalidDiscountException(String message){
        super("InvalidDiscountException  --  "+message);
    }
}
