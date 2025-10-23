package Workers;

public class Manager extends Employee {
    private double bonus;
    private int teamSize;

    public Manager(String name, int id, double baseSalary, double bonus, int teamSize) {
        super(name, id, baseSalary);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Мениджър ===");
        super.displayInfo();
        System.out.printf("Бонус: %.2fлв.%n", bonus);
        System.out.printf("Реална заплата: %.2fлв.%n", calculateSalary());
        System.out.printf("Членове в екипа: %d%n%n", teamSize);
    }
}
