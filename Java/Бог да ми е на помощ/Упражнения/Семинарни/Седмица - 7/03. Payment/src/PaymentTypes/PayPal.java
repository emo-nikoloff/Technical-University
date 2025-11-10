package PaymentTypes;

public class PayPal extends PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.printf("Плащане чрез PayPal акаунт: %s със сума %.2f лв.%n", email, amount);

    }
}
