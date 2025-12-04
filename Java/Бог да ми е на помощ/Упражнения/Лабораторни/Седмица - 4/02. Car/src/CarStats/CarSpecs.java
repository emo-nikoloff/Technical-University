package CarStats;

import java.util.Arrays;

public class CarSpecs {
    private String Brand;
    private String Model;
    private String Colour;
    private int Horsepower;
    private String Engine;
    private String Gearbox;
    private int Year;

    public CarSpecs() {
    }

    public CarSpecs(String brand, String model, String colour, int horsePower, String engine, String gearbox,
            int year) {
        this.Brand = brand;
        this.Model = model;
        this.Colour = colour;
        this.Horsepower = horsePower;
        this.Engine = engine;
        this.Gearbox = gearbox;
        this.Year = year;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        this.Colour = colour;
    }

    public int getPower() {
        return Horsepower;
    }

    public void setPower(int horsepower) {
        this.Horsepower = horsepower;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        this.Engine = engine;
    }

    public String getGearbox() {
        return Gearbox;
    }

    public void setGearbox(String gearbox) {
        this.Gearbox = gearbox;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public CarSpecs[] filterCars(CarSpecs[] cars, char letter) {
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            String car = cars[i].getBrand();
            char carBrandLetter = car.charAt(0);

            if (Character.toLowerCase(carBrandLetter) == Character.toLowerCase(letter)) {
                count++;
            }
        }

        CarSpecs[] filtered = new CarSpecs[count];
        int index = 0;

        for (int i = 0; i < cars.length; i++) {
            String car = cars[i].getBrand();
            char carBrandLetter = car.charAt(0);

            if (Character.toLowerCase(carBrandLetter) == Character.toLowerCase(letter)) {
                filtered[index] = cars[i];
                index++;
            }
        }

        return filtered;
    }

    public CarSpecs[] sortCars(CarSpecs[] cars, String order) {
        CarSpecs[] sorted = cars.clone();

        if (order.equalsIgnoreCase("ascending")) {
            Arrays.sort(sorted, (car1, car2) -> car1.getBrand().compareToIgnoreCase(car2.getBrand()));
        } else if (order.equalsIgnoreCase("descending")) {
            Arrays.sort(sorted, (car1, car2) -> car2.getBrand().compareToIgnoreCase(car1.getBrand()));
        }

        return sorted;
    }

    private boolean areCarsEqual(CarSpecs c1, CarSpecs c2) {
        return c1.getBrand().equals(c2.getBrand()) &&
                c1.getModel().equals(c2.getModel()) &&
                c1.getColour().equals(c2.getColour()) &&
                c1.getPower() == c2.getPower() &&
                c1.getEngine().equals(c2.getEngine()) &&
                c1.getGearbox().equals(c2.getGearbox()) &&
                c1.getYear() == c2.getYear();
    }

    public CarSpecs[] removeDuplicates(CarSpecs[] cars) {
        int uniqueCount = 0;

        for (int i = 0; i < cars.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (areCarsEqual(cars[i], cars[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                uniqueCount++;
            }
        }

        CarSpecs[] removed = new CarSpecs[uniqueCount];
        int index = 0;

        for (int i = 0; i < cars.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (areCarsEqual(cars[i], cars[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                removed[index] = cars[i];
                index++;
            }
        }

        return removed;
    }
}
