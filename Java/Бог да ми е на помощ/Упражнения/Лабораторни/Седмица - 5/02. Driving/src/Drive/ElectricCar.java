package Drive;

public class ElectricCar extends Car {
    private double batteryLevel;
    private double efficiency;

    public ElectricCar(String brand, double fuel, double batteryLevel, double efficiency) {
        super(brand, fuel);
        this.batteryLevel = batteryLevel;
        this.efficiency = efficiency;
    }

    public void charge(double percent) {
        batteryLevel += percent;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.printf("Батерията е заредена до %.2f%%.%n", batteryLevel);
    }

    public void driveElectric(int distance) {
        double batteryNeeded = distance / efficiency;

        if (batteryLevel >= batteryNeeded) {
            batteryLevel -= batteryNeeded;
            System.out.printf("Електрическата кола измина %dкм с ток.%n", distance);
        } else {
            System.out.printf("Недостатъчен заряд на батерията за %dкм.%n", distance);
        }
    }
}
