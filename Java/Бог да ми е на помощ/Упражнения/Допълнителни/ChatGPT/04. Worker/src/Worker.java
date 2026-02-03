import java.util.ArrayList;

import Workers.Developer;
import Workers.Employee;
import Workers.Manager;

public class Worker {
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Manager("Иван Иванов", 101, 2500, 800, 5));
        employees.add(new Manager("Мария Георгиева", 102, 2700, 1000, 8));
        employees.add(new Developer("Петър Петров", 201, 1800, "Java", 10));
        employees.add(new Developer("Георги Димитров", 202, 1900, "Python", 6));

        double totalSalaries = 0;
        for (Employee emp : employees) {
            emp.displayInfo();
            totalSalaries += emp.calculateSalary();
        }

        System.out.printf("Обща сума на заплатите: %.2fлв.%n", totalSalaries);
    }
}
