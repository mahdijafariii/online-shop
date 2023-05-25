package exception;

public class InsufficientMoneyException extends InvalidPurchaseException{

    InsufficientMoneyException(String message) {
        super(message);
    }
}
