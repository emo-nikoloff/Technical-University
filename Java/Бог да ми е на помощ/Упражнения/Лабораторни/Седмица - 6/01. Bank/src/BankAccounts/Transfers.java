package BankAccounts;

import Exceptions.InsufficientFundsException;

public interface Transfers {
    void transferMoney(Account target, double amount) throws InsufficientFundsException;
}
