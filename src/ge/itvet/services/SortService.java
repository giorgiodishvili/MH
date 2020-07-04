package ge.itvet.services;

import ge.itvet.university.Student;
import ge.itvet.university.Subject;

import java.util.Comparator;

//class shevqmeni sortirebistvis
public interface SortService {
    static class SortStudents extends Student implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.pointSum() - o1.pointSum();
        }
    }

    static class SortStudentsBySubject extends Student implements Comparator<Student> {
        Subject subject;

        SortStudentsBySubject(Subject subject) {
            this.subject = subject;

        }

        @Override
        public int compare(Student o1, Student o2) {
            return o2.getPointsBySubject(subject) - o2.getPointsBySubject(subject);
        }

    }

    static class SortStudentsByType extends Student implements Comparator<Student> {
        Subject.Type type1;

        SortStudentsByType(Subject.Type type) {
            type1 = type;
        }

        @Override
        public int compare(Student o1, Student o2) {
            return o2.getPointsByType(type1) - o1.getPointsByType(type1);
        }
    }

}
