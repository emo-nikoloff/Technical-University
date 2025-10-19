import CompanyParts.Department;
import CompanyParts.Employee;

public class WorkField {
    public static void main(String[] args) throws Exception {
        int employeeCount = 0;

        Employee emp1 = new Employee("Емилиян Николов", 12, "Staff Engineer", 420069.00);
        employeeCount++;

        Employee emp2 = new Employee("Неджимидин Хюсеин", 34, "Junior Developer", 23000.45);
        employeeCount++;

        Department department1 = new Department("Дръж Ми Шапката ЕООД", employeeCount);
        employeeCount = 0;

        department1.addEmployee(emp1);
        department1.addEmployee(emp2);

        department1.showAllEmployees();

        Employee emp3 = new Employee("Рожда Бекир", 123, "Staff Engineer", 69420.00);
        employeeCount++;

        Employee emp4 = new Employee("Ива Тодорова", 456, "Senior Developer", 34000.00);
        employeeCount++;

        Employee emp5 = new Employee("Сибел Камберова", 789, "Junior Developer", 17000.00);
        employeeCount++;

        Department department2 = new Department("Клуб Уинкс ЕООД", employeeCount);
        employeeCount = 0;

        department2.addEmployee(emp3);
        department2.addEmployee(emp4);
        department2.addEmployee(emp5);

        department2.showAllEmployees();
    }
}
