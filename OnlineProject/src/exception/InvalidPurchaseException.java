package exception;

public class InvalidPurchaseException extends Exception{
    InvalidPurchaseException(String message){
        super("InvalidInputException  --  " + message);
    }
}
