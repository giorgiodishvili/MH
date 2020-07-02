package ge.itvet.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Comparable<Student>{
    private Map<Subject, Integer> points = new HashMap<>();

    public void addPoint(Subject subject, int point) {
        points.put(subject, point);
    }

    public Map<Subject, Integer> getPoints() {
        return points;
    }

    private Integer pointSum(){

      int sum= points.entrySet().stream()
              .map(Map.Entry::getValue)
               .reduce(0, (Integer a,Integer b)-> {
            return a + b;
        });
    return sum;
    }

    @Override
    public int compareTo(Student o) {
        return o.pointSum()-pointSum();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "points= " + pointSum() +
                '}';
    }
}
