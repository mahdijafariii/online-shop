package exception;

public class InvalidInputException extends Exception{
    InvalidInputException(String message){
        super("Invalid Input !!! --  " + message);
    }
}
