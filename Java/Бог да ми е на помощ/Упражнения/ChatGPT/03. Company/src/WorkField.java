import CompanyParts.Department;
import CompanyParts.Employee;

public class WorkField {
    public static void main(String[] args) throws Exception {
        Department department1 = new Department("Дръж Ми Шапката ЕООД", 5);
        Department department2 = new Department("Клуб Уинкс ЕООД", 5);

        Employee emp1 = new Employee("Емилиян Николов", 12, "Staff Engineer", 420069.00);
        department1.addEmployee(emp1);

        Employee emp2 = new Employee("Неджимидин Хюсеин", 34, "Junior Developer", 23000.45);
        department1.addEmployee(emp2);

        Employee emp3 = new Employee("Рожда Бекир", 123, "Staff Engineer", 69420.00);
        department2.addEmployee(emp3);

        Employee emp4 = new Employee("Ива Тодорова", 456, "Senior Developer", 34000.00);
        department2.addEmployee(emp4);

        Employee emp5 = new Employee("Сибел Камберова", 789, "Junior Developer", 17000.00);
        department2.addEmployee(emp5);

        department1.showDepartmentInfo();
        department2.showDepartmentInfo();
    }
}
