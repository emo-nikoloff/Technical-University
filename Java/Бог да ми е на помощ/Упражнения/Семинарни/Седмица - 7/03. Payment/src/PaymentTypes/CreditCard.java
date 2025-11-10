package PaymentTypes;

public class CreditCard extends PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.printf("Плащане с кредитна карта %s на стойност %.2f лв.%n", cardNumber, amount);
    }
}
