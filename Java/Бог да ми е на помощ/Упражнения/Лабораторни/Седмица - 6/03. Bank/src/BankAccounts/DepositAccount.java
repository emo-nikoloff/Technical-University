package BankAccounts;

import Exceptions.InsufficientFundsException;

public class DepositAccount extends Account implements Transfers {
    private int depositPeriod;

    public DepositAccount(String iban, double balance, int depositPeriod) {
        super(iban, balance);
        this.depositPeriod = depositPeriod;
    }

    public int getDepositPeriod() {
        return depositPeriod;
    }

    @Override
    public double calculateInterest(double annualInterestRate) {
        double interest = balance * (annualInterestRate / 100.0) * (depositPeriod / 12.0);
        return interest;
    }

    @Override
    public void transferMoney(Account target, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатъчна наличност, за да бъде извършено прехвърлянето!");
        }
        this.withdraw(amount);
        target.deposit(amount);
    }
}
