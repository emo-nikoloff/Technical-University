import Drive.Car;
import Drive.ElectricCar;

public class Road {
    public static void main(String[] args) throws Exception {
        Car car = new Car("BMW", 20);
        car.accelerate(50);
        car.drive(100);
        car.refuel(10);
        car.drive(50);

        System.out.println();

        ElectricCar tesla = new ElectricCar("Tesla", 0, 80, 2.5);
        tesla.driveElectric(100);
        tesla.charge(15);
        tesla.driveElectric(200);

        Car[] cars = new Car[3];

        cars[0] = new Car("BMW", 20);
        cars[1] = new ElectricCar("Tesla", 0, 80, 2.5);
        cars[2] = new ElectricCar("Nissan Leaf", 0, 50, 2.0);

        // Полиморфизъм: обхождаме всички коли и извикваме подходящия метод
        for (Car vehicle : cars) {
            if (vehicle instanceof ElectricCar) {
                ElectricCar eCar = (ElectricCar) vehicle;
                System.out.println("\n--- Електрическа кола ---");
                eCar.driveElectric(100);
            } else {
                System.out.println("\n--- Обикновена кола ---");
                vehicle.drive(100);
            }
        }

        System.out.println("\n--- Демонстрация на общи методи ---");
        for (Car vehicle : cars) {
            vehicle.accelerate(30);
        }
    }
}
