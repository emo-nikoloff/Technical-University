package CompanyParts;

public class Department {
    private String name;
    private Employee[] employees;
    private int employeeCount;

    public Department(String name, int employeeCount) {
        this.name = name;
        this.employees = new Employee[employeeCount];
        this.employeeCount = employeeCount;
    }

    public void addEmployee(Employee emp) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = emp;
                break;
            }
        }
    }

    public void showAllEmployees() {
        System.out.printf("%s:%n", name);
        for (int i = 0; i < employees.length; i++) {
            employees[i].displayInfo();
        }

        System.out.printf("=> Средната заплата на фирмата е: %.2f%n", calculateAverageSalary());
        System.out.printf("=> Служителят с най-висока заплата е: %s със заплата %.2f%n%n",
                findHighestSalaryEmployee().getName(), findHighestSalaryEmployee().getSalary());
    }

    public double calculateAverageSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum / employees.length;
    }

    public Employee findHighestSalaryEmployee() {
        Employee bestEmp = employees[0];
        for (int i = 1; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp.getSalary() > bestEmp.getSalary()) {
                bestEmp = emp;
            }
        }
        return bestEmp;
    }
}
