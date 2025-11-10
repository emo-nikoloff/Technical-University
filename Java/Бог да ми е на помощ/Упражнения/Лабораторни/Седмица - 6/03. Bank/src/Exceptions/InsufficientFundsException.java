package Exceptions;

public class InsufficientFundsException extends Exception {
    private String errorMessage;

    public InsufficientFundsException() {
        this.errorMessage = "Недостатъчна наличност!";
    }

    public InsufficientFundsException(String message) {
        this.errorMessage = message;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
