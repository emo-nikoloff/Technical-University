package MoneyMaker;

public abstract class BankAccount implements Payable {
    protected double amount;
    protected double interest;

    public BankAccount() {

    }

    public BankAccount(double amount, double interest) {
        this.amount = amount;
        this.interest = interest;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

}
