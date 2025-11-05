package BankAccounts;

public class InsuffiecientFundsException extends Exception {
    @Override
    public String getMessage() {
        return "Недостатъчна наличност";
    }
}
