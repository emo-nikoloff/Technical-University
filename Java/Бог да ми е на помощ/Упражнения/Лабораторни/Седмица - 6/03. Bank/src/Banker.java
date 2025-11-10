import java.util.ArrayList;

import BankAccounts.DepositAccount;
import Exceptions.InsufficientFundsException;

public class Banker {
    public static void main(String[] args) {
        try {
            DepositAccount account1 = new DepositAccount("BG123", 1000, 12);
            DepositAccount account2 = new DepositAccount("BG456", 500, 6);

            ArrayList<DepositAccount> accounts = new ArrayList<>();
            accounts.add(account1);
            accounts.add(account2);

            for (DepositAccount account : accounts) {
                account.printAccount();
                System.out.printf("Лихва за периода от %d месеца: %.2f%n", account.getDepositPeriod(),
                        account.calculateInterest(5));
            }

            System.out.println("\nПревод между първа и втора сметка:");
            account1.transferMoney(account2, 1200);

            System.out.println("След трансфера:");
            for (DepositAccount account : accounts) {
                account.printAccount();
            }
        } catch (InsufficientFundsException error) {
            System.out.println(error.getMessage());
        }
    }
}
