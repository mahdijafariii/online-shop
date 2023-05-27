package exception;

public class InsufficientAmountOfProductException extends InvalidPurchaseException{

    public InsufficientAmountOfProductException(String message) {
        super(message);
    }
}
