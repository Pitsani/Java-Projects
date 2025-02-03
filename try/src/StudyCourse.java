import java.util.List;
import java.util.ArrayList;

public abstract class StudyCourse {
    protected List<Student> students = new ArrayList<>();

    public abstract void newStudent(String name, int[] grades);

    public abstract double averageGrade();

}
