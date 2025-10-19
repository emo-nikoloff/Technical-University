package CompanyParts;

public class Employee {
    private String name;
    private int id;
    private String position;
    private double salary;

    public Employee() {

    }

    public Employee(String name, int id, String position, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.printf("---%d---%n", id);
        System.out.println(name);
        System.out.println(position);
        System.out.printf("%.2f лв.%n%n", salary);
    }
}
