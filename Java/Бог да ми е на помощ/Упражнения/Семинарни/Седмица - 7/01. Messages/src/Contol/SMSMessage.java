package Contol;

public class SMSMessage implements Message {
    @Override
    public void send() {
        System.out.println("Изпратен е СМС!");
    }
}
