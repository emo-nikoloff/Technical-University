import StudentStats.Student;

public class StudentInfo {
    public static void main(String[] args) throws Exception {
        Student[] students = new Student[2];

        Student student1 = new Student("Емилиян Николов", "121224184");
        Student student2 = new Student("Неджимидин Хюсеин", "121224107");
        students[0] = student1;
        students[1] = student2;

        student1.addGrade(5);
        student1.addGrade(6);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        student2.addGrade(2);
        student2.addGrade(2);
        student2.addGrade(2);
        student2.addGrade(2);
        student2.addGrade(2);

        for (Student student : students) {
            student.displayInfo();
        }

        Student bestStudent = students[0];
        for (Student student : students) {
            if (student.calculateAverage() > bestStudent.calculateAverage()) {
                bestStudent = student;
            }
        }

        System.out.printf("Ученикът с по-висок успех е: %s с успех %.2f%n", bestStudent.getName(),
                bestStudent.calculateAverage());
    }
}
