import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String UCN;
    private String facultyNumber;

    public Student(String UCN, String facultyNumber) throws StudentException {
        if (UCN.matches("\\d{10}") && facultyNumber.matches("\\d{9}")) {
            this.UCN = UCN;
            this.facultyNumber = facultyNumber;
        } else {
            throw new StudentException("Invalid input.");
        }

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Student student = (Student) object;
        return Objects.equals(UCN, student.UCN) &&
                Objects.equals(facultyNumber, student.facultyNumber);
    }
}
