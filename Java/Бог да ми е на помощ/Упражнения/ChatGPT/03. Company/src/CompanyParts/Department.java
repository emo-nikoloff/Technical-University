package CompanyParts;

public class Department {
    private String name;
    private Employee[] employees;
    private int employeeCount;

    public Department(String name, int capacity) {
        this.name = name;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }

    public void addEmployee(Employee emp) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = emp;
            employeeCount++;
            System.out.printf("Добавен е служител: %s в отдел %s%n", emp.getName(), name);
        } else {
            System.out.println("Отделът е пълен. Не може да се добавят повече служители.");
        }
    }

    public void showDepartmentInfo() {
        System.out.printf("%s:%n", name);
        if (employeeCount == 0) {
            System.out.println("Няма служители в отдела!");
            return;
        }

        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayInfo();
        }

        System.out.printf("=> Средната заплата на фирмата е: %.2f%n", calculateAverageSalary());
        System.out.printf("=> Служителят с най-висока заплата е: %s със заплата %.2f%n%n",
                findHighestSalaryEmployee().getName(), findHighestSalaryEmployee().getSalary());
    }

    public double calculateAverageSalary() {
        if (employeeCount == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int i = 0; i < employeeCount; i++) {
            sum += employees[i].getSalary();
        }
        return sum / employees.length;
    }

    public Employee findHighestSalaryEmployee() {
        if (employeeCount == 0) {
            return null;
        }

        Employee bestEmp = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            Employee emp = employees[i];
            if (emp.getSalary() > bestEmp.getSalary()) {
                bestEmp = emp;
            }
        }
        return bestEmp;
    }
}
