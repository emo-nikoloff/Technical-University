/*Създайте система за съобщения с класове EmailMessage, SMSMessage и PushNotification, които наследяват интерфейса Message. Използвайте фабрика, за да създадете съобщение според въведен тип.
Обяснение:
1. Интерфейс Message - Създаваме интерфейс Message с метод send(). Това дава възможност за обща функционалност при изпращането на съобщения.
2. Класове за съобщения - Имплементираме три класа EmailMessage, SMSMessage и PushNotification, всеки от които имплементира интерфейса Message и дефинира своя версия на метода send().
3. Фабрика MessageFactory - Класът MessageFactory има метод createMessage(String type), който приема тип съобщение и връща обект от съответния клас. Това позволява да създаваме различни видове
съобщения без да е нужно да знаем техните детайли.*/

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
