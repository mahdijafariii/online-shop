package exception;

public class InsufficientAmountOfProductException extends InvalidPurchaseException{

    InsufficientAmountOfProductException(String message) {
        super(message);
    }
}
