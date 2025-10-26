package Devices;

public class Lamp implements Switchable, Describable {
    private boolean isOn;

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Лампата е включена.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Лампата е изключена.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void describe() {
        System.out.println("Това е настолна лампа.");
    }
}
