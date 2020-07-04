package ge.itvet.university;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student extends Person {
    private Map<Subject, Integer> points = new HashMap<>();
    private Map<Subject.Type, Integer> typepoint = new HashMap<>();
    Subject subject1;

    public void addPoint(Subject subject, int point) {
        subject1 = subject;
        typepoint.put(subject.getType(), point);
        points.put(subject, point);
    }

    public Subject getSubject() {
        return subject1;
    }

    public Map<Subject, Integer> getPoints() {
        return points;
    }

    public int getPointsBySubject(Subject subject) {
        return points.get(subject);
    }

    public int getPointsByType(Subject.Type type) {
        return typepoint.get(type);
    }

    public Integer pointSum() {

        int sum = points.entrySet().stream()
                .map(Map.Entry::getValue)
                .reduce(0, (Integer a, Integer b) -> {
                    return a + b;
                });
        return sum;
    }
//    public Integer pointSumBySubject(Subject subject){
//        int sum = points.entrySet().stream()
//                .filter(group -> group.getKey()==subject)
//                .map(Map.Entry::getValue)
//                .reduce(0,(Integer a,Integer b) -> a+b);
//        return sum;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "points=" + pointSum() +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(points, student.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
