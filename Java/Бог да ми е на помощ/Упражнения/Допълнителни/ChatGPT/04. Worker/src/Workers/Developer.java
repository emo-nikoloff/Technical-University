package Workers;

public class Developer extends Employee {
    private String programmingLanguage;
    private int overtimeHours;

    public Developer(String name, int id, double baseSalary, String programmingLanguage, int overtimeHours) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
        this.overtimeHours = overtimeHours;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (overtimeHours * 25);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Разработчик ===");
        super.displayInfo();
        System.out.printf("Програмен език: %s%n", programmingLanguage);
        System.out.printf("Извънредни часове: %d%n", overtimeHours);
        System.out.printf("Реална заплата: %.2fлв.%n%n", calculateSalary());
    }
}
