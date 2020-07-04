package ge.itvet.services;

import ge.itvet.university.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupService {

    private static List<Group> groups = new ArrayList<>();
    private static StudentService studentService = new StudentService();
    private static SubjectService subjectService = new SubjectService();

    static {
        for (String name : new String[]{"Thanos", "Captain America", "Iron Man", "Black widow"}) {
            Group group = new Group();
            group.setName(name);
            group.addStudents(studentService.getStudents(2));
            group.addSubjects(subjectService.getSubjects());
            groups.add(group);
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

}
