package exception;

public class InvalidPurchaseException extends Exception{
    public InvalidPurchaseException(String message){
        super("InvalidInputException  --  " + message);
    }
}
