public class CarSpecs {
    String Brand;
    String Model;
    String Colour;
    int Horsepower;
    String Engine;
    String Gearbox;
    int ReleaseYear;

    public String getBrand(String brand) {
        return setBrand(brand);
    }

    public String setBrand(String brand) {
        return this.Brand = brand;
    }

    public String getModel(String model) {
        return setModel(model);
    }

    public String setModel(String model) {
        return this.Model = model;
    }

    public String getColour(String colour) {
        return setColour(colour);
    }

    public String setColour(String colour) {
        return this.Colour = colour;
    }

    public int getHorsepower(int horsepower) {
        return setHorsepower(horsepower);
    }

    public int setHorsepower(int horsepower) {
        return this.Horsepower = horsepower;
    }

    public String getEngine(String engine) {
        return setEngine(engine);
    }

    public String setEngine(String engine) {
        return this.Engine = engine;
    }

    public String getGearbox(String gearbox) {
        return setGearbox(gearbox);
    }

    public String setGearbox(String gearbox) {
        return this.Gearbox = gearbox;
    }

    public int getReleaseYear(int releaseYear) {
        return setReleaseYear(releaseYear);
    }

    public int setReleaseYear(int releaseYear) {
        return this.ReleaseYear = releaseYear;
    }

}
