/*Създайте абстрактен клас PaymentMethod с метод processPayment(). Имплементирайте класове CreditCard и PayPal, които го наследяват. Програмата да връща избрания метод за плащане.
Обяснение:
1. Абстрактен клас PaymentMethod - Дефинираме абстрактен клас PaymentMethod с метод processPayment(), който трябва да бъде имплементиран от всеки наследник.
2. Имплементации CreditCard и PayPal - Създаваме класовете CreditCard и PayPal, които имплементират processPayment() с различни поведения за обработка на плащане.*/

import PaymentTypes.CreditCard;
import PaymentTypes.PayPal;
import PaymentTypes.PaymentMethod;

public class Pay {
    public static void main(String[] args) throws Exception {
        PaymentMethod card = new CreditCard("1234-5678-9012-3456");
        PaymentMethod paypal = new PayPal("user@mail.com");

        card.processPayment(120.50);
        paypal.processPayment(89.99);
    }
}
