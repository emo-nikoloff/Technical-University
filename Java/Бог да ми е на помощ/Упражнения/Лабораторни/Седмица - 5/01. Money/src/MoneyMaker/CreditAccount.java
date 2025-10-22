package MoneyMaker;

public class CreditAccount extends BankAccount {
    private int months;

    public CreditAccount(double amount, double interst, int months) {
        super(amount, interst);
        this.months = months;
    }

    @Override
    public double pay() {
        double balance = getAmount();
        for (int i = 0; i < months; i++) {
            balance += (balance * getInterest());
        }
        return balance;
    }
}
