package BankAccounts;

public class DepositAccount extends Account {
    private int depositPeriod;

    public DepositAccount(double balance, String iBAN, int depositPeriod) {
        super(balance, iBAN);
        this.depositPeriod = depositPeriod;
    }

    public void setDepositPeriod(int depositPeriod) {
        this.depositPeriod = depositPeriod;
    }

    public int getDepositPeriod() {
        return depositPeriod;
    }

    @Override
    public double calculateInterest() {
        double interest = balance * 0.03 * (depositPeriod / 12.0);
        return interest;
    }

    @Override
    public double transferMoney(double amount) {
        return balance += amount;
    }
}