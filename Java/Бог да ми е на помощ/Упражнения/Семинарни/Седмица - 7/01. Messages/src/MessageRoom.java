import Contol.Message;

public class MessageRoom {
    public static void main(String[] args) throws Exception {
        Message email = MessageFactory.createMessage("email");
        email.send();

        Message sms = MessageFactory.createMessage("sms");
        sms.send();

        Message push = MessageFactory.createMessage("push");
        push.send();
    }
}
