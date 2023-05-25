package exception;

public class InvalidDiscountException extends Exception{
    InvalidDiscountException(String message){
        super("InvalidDiscountException  --  "+message);
    }
}
