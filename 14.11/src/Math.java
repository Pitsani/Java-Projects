public class Math extends StudyCourse {
    public Math(String courseName) {
        super(courseName);
    }

    public void newStudent(String name, int[] grades) {
        students.add(new Student(name, grades));
    }

    @Override
    public double grade() {
        int broiOcenki = 0;
        int ocenkiSuma = 0;
        for (Student student : students) {
            for (int grades : student.grades) {
                ocenkiSuma += grades;
                broiOcenki++;
            }

        }
        return broiOcenki > 0 ? (double) ocenkiSuma / broiOcenki : 0;
    }
}
