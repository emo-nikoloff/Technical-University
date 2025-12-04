/*1. Дефинирайте два интерфейса:
•   Switchable – определя поведението за включване, изключване и проверка на
    състоянието на устройството. Съдържа методи:
    o   turnOn;
    o   turnOff;
    o   isOn;
•   Describable – определя метод за описание на устройството. Съдържа метод:
    o   describe;
2. Създайте класове, които имплементират интерфейсите:
•   Клас Lamp
    o   имплементира Switchable и Describable;
    o   съдържа поле за състояние (включена/изключена) isOn;
    o   при включване и изключване извежда съответно съобщения:
­        Лампата е включена.
­        Лампата е изключена.
    o   describe() извежда: Това е настолна лампа.
•   Клас TV
    o   имплементира Switchable и Describable;
    o   съдържа поле за състояние isOn;
    o   при включване и изключване извежда:
­        Телевизорът е включен.
­        Телевизорът е изключен.
    o   методът describe() извежда: Това е смарт телевизор.
3. Главен клас: Main
•   да се създаде масив или списък от обекти тип Switchable, който съдържа
    обекти Lamp и TV;
•   чрез полиморфизъм да се включат всички устройства;
•   след това да се извикат методите describe() за всяко устройство.*/

import java.util.ArrayList;
import java.util.List;

import Devices.Describable;
import Devices.Lamp;
import Devices.Switchable;
import Devices.TV;

public class Household {
    public static void main(String[] args) throws Exception {
        List<Switchable> devices = new ArrayList<>();

        Switchable lamp = new Lamp();
        Switchable TV = new TV();

        devices.add(lamp);
        devices.add(TV);

        for (Switchable device : devices) {
            device.turnOn();
        }

        System.out.println();

        for (Switchable device : devices) {
            if (device instanceof Describable deviceType) {
                deviceType.describe();
            }
        }

        System.out.println();

        for (Switchable device : devices) {
            device.turnOff();
        }
    }
}
