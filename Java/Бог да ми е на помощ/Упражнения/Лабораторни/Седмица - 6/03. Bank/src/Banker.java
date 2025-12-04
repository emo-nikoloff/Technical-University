/*Създайте абстрактен клас “Сметка” (Account) с полета за баланс (balance) и банков идентификационен номер (IBAN). Дефинирайте абстрактен метод “лихва” (calculateInterest), който ще се използва
за пресмятане на лихвата за даден период. Дефинирайте методи за депозиране (deposit) и теглене на пари (withdraw), които ще манипулират баланса на сметката, и метод
“принтирай сметка” (printAccount), който извежда информацията за сметката (IBAN и баланс). Класът “ДепозитнаСметка” (DepositAccount), който наследява “Сметка” има допълнително поле за срок на
депозита (depositPeriod) в месеци. Реализирайте метода за пресмятане на лихвата така, че да зависи от баланса и срока на депозита. Създайте интерфейс “Преводи” (Transfers). Дефинирайте метод
transferMoney, който прехвърля сума от една сметка към друга. Методът трябва да хвърля изключение “Не достатъчно наличност” (InsufficientFundsException), ако сметката няма достатъчно средства
за превода.*/

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
