package BankAccounts;

import Exceptions.InsufficientFundsException;

public abstract class Account {
    protected String iban;
    protected double balance;

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    protected abstract double calculateInterest(double annualInterestRate);

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатъчна наличност, за да бъде извършено тегленето!");
        }
        balance -= amount;
    }

    public void printAccount() {
        System.out.println("--Сметка--");
        System.out.printf("-IBAN: %s%n", iban);
        System.out.printf("-Баланс по сметката: %.2fлв.%n", balance);
    }
}
