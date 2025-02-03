public class Grade {
    private String subject;
    private int semester;
    private int grade;

    public Grade(String subject, int grade, int semester) {
        this.subject = subject;
        this.grade = grade;
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public int getSemester() {
        return semester;
    }

    public int getGrade() {
        return grade;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
