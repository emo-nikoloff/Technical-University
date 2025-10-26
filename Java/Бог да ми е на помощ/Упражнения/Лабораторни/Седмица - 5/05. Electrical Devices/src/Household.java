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
