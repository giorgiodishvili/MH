package ge.itvet.services;

import ge.itvet.university.Subject;

import java.util.List;
import java.util.Random;

public class ExamService {
    private static GroupService groupService = new GroupService();
    private static SubjectService subjectService = new SubjectService();

    {
        Random random = new Random();
        List<Subject> subjects = subjectService.getSubjects();
        groupService.getGroups().stream()
                .flatMap(group -> group.getStudents().stream())
                .forEach(student -> subjects.forEach(subject -> student.addPoint(subject, 21 + random.nextInt(80))));
        ;
    }

}
