package ge.itvet.services;

import ge.itvet.university.Group;
import ge.itvet.university.Student;
import ge.itvet.university.Subject;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticService {
    private static final GroupService service = new GroupService();
   // private static final StudentService student = new StudentService();

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
                                                    .map( (Map.Entry<Subject, Integer> subjectPointEntry) -> subjectPointEntry.getValue())
                                                    .reduce(Integer::sum);
                                    return Map.entry(entry.getKey(), reduce.get());
                                }
                        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return typeIntegerMap;
    }
    public List<Student> sortStudents5(){
        List<Student> collect = service.getGroups().stream()
                .flatMap(group -> group.getStudents().stream())
                .collect(Collectors.toList());
        Collections.sort(collect);
        return collect;
    }
    public Map<Subject.Type, Integer>  sortGroupByType() {
                long size = service.getGroups().stream()
               .flatMap(group -> group.getStudents().stream()).count();

        Map<Subject.Type, Integer> typeIntegerMap = sumOfPointsGroupBySubjectType();
        typeIntegerMap.replaceAll((s, v) -> v /(int) size);
        return typeIntegerMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Subject.Type, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }


}
