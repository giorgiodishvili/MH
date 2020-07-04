package ge.itvet.university;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(students, group.students) &&
                Objects.equals(subjects, group.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students, subjects);
    }
}
