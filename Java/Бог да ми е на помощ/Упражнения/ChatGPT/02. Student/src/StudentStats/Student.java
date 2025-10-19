package StudentStats;

public class Student {
    private String name;
    private String studentID;
    private double[] grades;

    public Student() {

    }

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.grades = new double[5];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public double[] getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == 0) {
                grades[i] = grade;
                break;
            }
        }
    }

    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    public void displayInfo() {
        System.out.printf("Студент: %s%n", name);
        System.out.printf("-> Факултетен номер: %s%n", studentID);
        System.out.print("-> Оценки: ");
        for (int i = 0; i < grades.length; i++) {
            if (i != 4) {
                System.out.printf("%.2f, ", grades[i]);
            } else {
                System.out.printf("%.2f%n", grades[i]);
            }
        }
        System.out.printf("--> Средноаритметично: %.2f%n", calculateAverage());
    }
}
