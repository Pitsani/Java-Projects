import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<StudyCourse> courses = new ArrayList<>();
        courses.add(new Math("Математика"));
        courses.add(new Informatics("Информатика"));
        Scanner scan = new Scanner(System.in);
        for(StudyCourse course : courses) {
            System.out.println("Курс: " + course.getCourseName());
            for (int i = 1; i <= 5; i++) {
                System.out.print("Студент " + i + ", Име: ");
                String name = scan.next();
                int[] grades = new int[3];
                System.out.println("Оценки: ");
                for (int j = 0; j < 3; j++) {
                    grades[j] = scan.nextInt();
                }
                course.newStudent(name, grades);
            }
        }

        try (BufferedWriter wr = new BufferedWriter(new FileWriter("courses_info.txt"))) {
            for (StudyCourse course : courses) {
                wr.write("Курс: " + course.getCourseName() + "\n");
                for (Student student : course.getStudents()) {
                    wr.write(" Студент: " + student.name + ", Оценки: ");
                    for (int grade : student.grades) {
                        wr.write(grade + " ");
                    }
                    wr.write("\n");
                }
                wr.write("\n");
            }
            System.out.println("Информацията за курса е успешно записана");
        } catch (IOException e) {
            System.out.println("Грешка при запис");
        }

        try (BufferedWriter wr1 = new BufferedWriter(new FileWriter("grades_info.txt"))) {
            for (StudyCourse course : courses) {
                double middleGrade = course.grade();
                wr1.write("Курс: " + course.getCourseName() + " Среден успех: " + middleGrade + "\n");
            }
            System.out.println("Информацията за средния успех е успешно записана");
        } catch (IOException e) {
            System.out.println("Грешка при запис");
        }
    }
}
