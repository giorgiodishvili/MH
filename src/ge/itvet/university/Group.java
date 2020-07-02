package ge.itvet.university;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void addSubjects(Collection<Subject> subject) {
        this.subjects.addAll(subject);
    }

    public boolean removeSubject(Subject subject) {
        return subjects.remove(subject);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(Collection<Student> student) {
        this.students.addAll(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }
}
