/*1.Създайте клас Car. Като член променливи има марка, модел, цвят, мощност, тип двигател, тип скоростна кутия, година на производство. Създайте гет и сет методи. Създайте конструктор с и
без параметри.
2.Създайте метод, който по подаден масив от коли и параметър буква(char), “прочиства” масива от коли и връща нов масив от коли, на които марките им започват с подадената като параметър буква.
3.Създайте втори метод, който по подаден параметър масив от коли, връща отново масив от коли, но сортиран по възходящ или по низходящ ред, в зависимост от марката на колата. Нека редът да се
определя от параметър на метода.
4.Създайте трети метод, който по подаден масив от коли проверява дали измежду колите има повтарящи се и връща “прочистен” масив от коли, в който няма повтарящи се коли.
5.Създайте клас Test с main метод, в който създайте няколко коли и изтествайте трите метода дали работят правилно.*/

import CarStats.CarSpecs;

public class Car {
    public static void main(String[] args) throws Exception {
        CarSpecs car1 = new CarSpecs("Audi", "A4", "Black", 150, "Petrol", "Automatic", 2018);
        CarSpecs car2 = new CarSpecs("BMW", "320", "White", 190, "Diesel", "Automatic", 2020);
        CarSpecs car3 = new CarSpecs("Alfa Romeo", "Giulia", "Red", 200, "Petrol", "Manual", 2019);
        CarSpecs car4 = new CarSpecs("Audi", "A4", "Black", 150, "Petrol", "Automatic", 2018); // дубликат
        CarSpecs car5 = new CarSpecs("Citroen", "C4", "Grey", 110, "Petrol", "Manual", 2015);

        CarSpecs[] cars = { car1, car2, car3, car4, car5 };

        System.out.println("=== Cars starting with 'A' ===");
        CarSpecs[] filtered = car1.filterCars(cars, 'A');

        for (CarSpecs car : filtered) {
            System.out.println(car.getBrand() + " " + car.getModel());
        }

        System.out.println("\n=== Sorted ascending (Brand) ===");
        CarSpecs[] sortedAsc = car1.sortCars(cars, "ascending");
        for (CarSpecs car : sortedAsc) {
            System.out.println(car.getBrand() + " " + car.getModel());
        }

        System.out.println("\n=== Sorted descending (Brand) ===");
        CarSpecs[] sortedDesc = car1.sortCars(cars, "descending");
        for (CarSpecs car : sortedDesc) {
            System.out.println(car.getBrand() + " " + car.getModel());
        }

        System.out.println("\n=== Without duplicates ===");
        CarSpecs[] unique = car1.removeDuplicates(cars);
        for (CarSpecs car : unique) {
            System.out.println(car.getBrand() + " " + car.getModel());
        }
    }
}
