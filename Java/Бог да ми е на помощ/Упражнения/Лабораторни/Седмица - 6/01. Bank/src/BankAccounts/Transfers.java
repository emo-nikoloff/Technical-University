package BankAccounts;

public interface Transfers {
    double transferMoney(double amount) throws InsuffiecientFundsException;
}
