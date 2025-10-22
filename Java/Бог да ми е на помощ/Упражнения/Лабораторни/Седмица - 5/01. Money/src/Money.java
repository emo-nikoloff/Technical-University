/*Създайте interface Payable с абстрактен метод pay, който да връща double. Създайте абстрактен клас BankAccount, който имплементира Payable.
BankAccount съдържа 2 полета - Amount(сума), Interest(лихва). Създайте конструктор, getter и setter.
Създайте конкретен клас DebitAccount, който наследява BankAccount и връща резултат сумата + лихвата.
Създайте клас CreditAccount, който наследява BankAccount и има допълително поле months. Pay метода трябва да изчислява сумата по сложна лихва.*/

import MoneyMaker.CreditAccount;
import MoneyMaker.DebitAccount;
import MoneyMaker.Payable;

public class Money {
    public static void main(String[] args) throws Exception {
        Payable debit = new DebitAccount(100, 0.1);
        Payable credit = new CreditAccount(100, 0.1, 2);

        System.out.println(debit.pay());
        System.out.println(credit.pay());
    }
}
