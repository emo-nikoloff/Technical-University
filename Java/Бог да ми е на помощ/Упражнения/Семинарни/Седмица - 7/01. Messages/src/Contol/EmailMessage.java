package Contol;

public class EmailMessage implements Message {
    @Override
    public void send() {
        System.out.println("Изпратен е имейл!");
    }
}
