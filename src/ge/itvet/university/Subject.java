package ge.itvet.university;

import java.util.List;

public class Subject {
    private final Type type;
    private String name;
    private List<Lecturer> lecturers;

    public Subject(Type type) {
        this.type = type;
    }

    public Subject(Type type, String name) {
        this(type);
        this.name = name;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", lecturers=" + lecturers +
                '}';
    }

    public static enum Type {
        HUMANITARIAN,
        TECHNICAL;

    }
}
