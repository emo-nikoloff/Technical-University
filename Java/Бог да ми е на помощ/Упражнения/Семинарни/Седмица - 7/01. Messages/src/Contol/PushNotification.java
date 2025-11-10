package Contol;

public class PushNotification implements Message {
    @Override
    public void send() {
        System.out.println("Изпратена е push нотификация!");
    }
}
