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
