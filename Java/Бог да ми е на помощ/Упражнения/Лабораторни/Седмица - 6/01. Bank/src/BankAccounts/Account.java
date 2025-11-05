package BankAccounts;

public abstract class Account implements Transfers {
    protected double balance;
    protected String IBAN;

    public Account(double balance, String iBAN) {
        this.balance = balance;
        this.IBAN = iBAN;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public abstract double calculateInterest();

    public double deposit(double sum) {
        return balance + sum;
    }

    public double withdraw(double sum) {
        return balance - sum;
    }

    public void printAccount() {
        System.out.printf("IBAN: %s%n", IBAN);
        System.out.printf("Баланс по сметката: %.2f", balance);
    }
}
