package ge.itvet.services;

import ge.itvet.university.Group;
import ge.itvet.university.Student;
import ge.itvet.university.Subject;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticService {
    private static final GroupService service = new GroupService();

    public Map<Subject.Type, Integer> sumOfPointsGroupBySubjectType() {
        Map<Subject.Type, List<Map.Entry<Subject, Integer>>> collect =
                service.getGroups().stream()
                        .flatMap(group -> group.getStudents().stream())
                        .flatMap(student -> student.getPoints().entrySet().stream())
                        .collect(Collectors.groupingBy(entry -> entry.getKey().getType()));

        Map<Subject.Type, Integer> typeIntegerMap =
                collect.entrySet().stream()
                        .map((Map.Entry<Subject.Type, List<Map.Entry<Subject, Integer>>> entry) -> {
                                    Optional<Integer> reduce =
                                            entry.getValue().stream()
                                                    .map(Map.Entry::getValue)
                                                    .reduce(Integer::sum);
                                    return Map.entry(entry.getKey(), reduce.get());
                                }
                        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return typeIntegerMap;
    }

    public List<Student> sortStudents5() {
        List<Student> collect = service.getGroups().stream()
                .flatMap(group -> group.getStudents().stream())
                .collect(Collectors.toList());
        Collections.sort(collect, new SortService.SortStudents());
        return collect;
    }


    public List<Group> sortBySubject(final Subject subject) {
        Map<Group, List<Student>> collect = service.getGroups().stream()
                .collect(Collectors.toMap(a -> a, Group::getStudents));

        return
                collect.entrySet().stream()
                        .map(groupListEntry -> Map.entry(groupListEntry.getKey(), groupListEntry.getValue().stream()
                                .map(student -> student.getPointsBySubject(subject))
                                .reduce(0, Integer::sum) / groupListEntry.getValue().size()))
                        .sorted((e1, e2) -> e2.getValue() - e1.getValue())
//                       .peek(System.out::println)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

    }

    public Map<Subject.Type, Integer> sortGroupByType() {
        long size = service.getGroups().stream()
                .flatMap(group -> group.getStudents().stream()).count();
        Map<Subject.Type, Integer> typeIntegerMap = sumOfPointsGroupBySubjectType();
        typeIntegerMap.replaceAll((s, v) -> v / (int) size);
        return typeIntegerMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Subject.Type, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
    //amaze kargad vegar vichaliche imas imdeni dro shevaxarje(gamocdebistvisac vemzadebi sorry :D) (xval vcdi kide)
    public List<Student> sortStudentsByType(Subject.Type type) {

        List<Student> collect = service.getGroups().stream()
                .flatMap(s -> s.getStudents().stream())
                .filter(entry -> entry.getSubjectType().equals(type))

                .collect(Collectors.toList());



        collect.sort(new SortService.SortStudentsByType(type));
        return collect;

    }
}

