package Workers;

public class Employee {
    private String name;
    private int id;
    private double baseSalary;

    public Employee() {
    }

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void displayInfo() {
        System.out.printf("--- %s ---%n", name);
        System.out.printf("ИД: %d%n", id);
        System.out.printf("Заплата: %.2fлв.%n", baseSalary);
    }
}
