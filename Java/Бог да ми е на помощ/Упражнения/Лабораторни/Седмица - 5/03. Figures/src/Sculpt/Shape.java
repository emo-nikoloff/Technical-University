package Sculpt;

public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();

    public abstract double perimeter();

    public void displayColor() {
        System.out.printf("Цветът на фигурата е %s.%n", color);
    }
}
