public class Math extends StudyCourse{
    @Override
    public void newStudent(String name, int[] grades) {
        students.add(new Student(name, grades));
    }

    @Override
    public double averageGrade() {

        return 0;
    }
}
