package Drive;

public class Car {
    private String brand;
    private double speed;
    private double fuel;
    private double mileage;

    public Car() {

    }

    public Car(String brand, double fuel) {
        this.brand = brand;
        this.fuel = fuel;
        this.speed = 0;
        this.mileage = 0;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void accelerate(double acceleration) {
        speed += acceleration;
        System.out.printf("Ускорявате до %.2fкм/ч.%n", speed);
    }

    public void refuel(double litres) {
        fuel += litres;
        System.out.printf("Добавени са  %.2fL гориво. Общо гориво: %.2fL.%n", litres, fuel);
    }

    public void drive(int distance) {
        double fuelNeeded = distance * 0.1;
        if (fuel >= fuelNeeded) {
            mileage += distance;
            fuel -= fuelNeeded;
            System.out.printf("Изминахте %dкм.%n", distance);
        } else {
            System.out.printf("Няма достатъчно гориво за разстоянието от %dкм.%n", distance);

        }
    }
}
