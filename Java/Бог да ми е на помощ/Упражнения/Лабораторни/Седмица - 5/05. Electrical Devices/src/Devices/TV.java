package Devices;

public class TV implements Switchable, Describable {
    private boolean isOn;

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Телевизорът е включен.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Телевизорът е изключен.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void describe() {
        System.out.println("Това е смарт телевизор.");
    }
}
