import java.util.ArrayList;
import java.util.List;

public abstract class StudyCourse {
    protected String courseName;
    protected List<Student> students;

    public StudyCourse(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public abstract void newStudent(String name, int[] grades);

    public abstract double grade();

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudents() {
        return students;
    }
}
