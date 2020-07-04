package ge.itvet.services;

import ge.itvet.university.Student;
import ge.itvet.university.Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
    private String[] names = {"Soso", "Joseph", "Vaxo", "Anz2"};
    private String[] surnames = {"Kakabadze", "Jugashvili", "Vaxtangishvili", "Labadze"};

    public List<Student> getStudents(int amount) {
        Random random = new Random();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Student student = new Student();
            student.setName(names[random.nextInt(names.length)]);
            student.setSurname(surnames[random.nextInt(surnames.length)]);
            list.add(student);
        }
        return list;
    }
}
