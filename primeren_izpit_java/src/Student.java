import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private List<Grade> grades;

    public Student(String facultyNumber, String EGN) {
        super(facultyNumber, EGN);
        grades = new ArrayList<>();
    }

    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }
}
