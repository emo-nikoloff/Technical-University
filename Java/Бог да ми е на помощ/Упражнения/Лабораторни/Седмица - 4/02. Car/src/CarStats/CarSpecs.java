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

    CarSpecs() {
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
        if (order == "ascending") {
            Arrays.sort(cars, (car1, car2) -> car1.getBrand().compareToIgnoreCase(car2.getBrand()));
        } else if (order == "descending") {
            Arrays.sort(cars, (car1, car2) -> car2.getBrand().compareToIgnoreCase(car1.getBrand()));
            Arrays.sort(null, null);
        }
        return cars;
    }
}
