package ge.itvet;

import ge.itvet.services.ExamService;
import ge.itvet.services.GroupService;
import ge.itvet.services.StatisticService;
import ge.itvet.university.Subject;

//bevri vewvale tu cota vgoneb bevri rame davamugame tenkiu :DD
public class Main {
    public static void main(String[] args) {
      new ExamService();
        StatisticService statisticService = new StatisticService();
//      Subject subject = new Subject(Subject.Type.TECHNICAL,"Java");
//        System.out.println("typePointsMap = " + statisticService.sumOfPointsGroupBySubjectType());
//        System.out.println(statisticService.sortGroupByType());
//        System.out.println(statisticService.sortBySubject(subjectService.getSubjects().get(0)));
//        System.out.println(statisticService.sortStudents5());
        System.out.println();
        System.out.println(new GroupService().getGroups().get(0).getStudents());
//        System.out.println(statisticService.sortStudentsByType(Subject.Type.TECHNICAL));
//        System.out.println(statisticService.sortStudentsBySubject(subject));
//        System.out.println(new GroupService().getGroups().get(0).getStudents());
     /*
     X 1.ქულების გენერცია თითოეული გრუპის სტუდენტზე
     X 2.საგნის ტიპის მიხედვით ქულების ჯამის დაბრუნება
     X 3.დავალაგოთ ჯგუფები საგნების  ტიპის მიხედვით(სად უფრო მეტი საშუალო ქულაა)
     X 4.დავალაგოთ ჯგუფები საგნის მიხედვით(სად უფრო მეტი საშუალო ქულაა)*
     X 5.დავალაგოთ სტუდენტები ქულების მიხედვით
     6.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგანში)
     7.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგნებში)*
     8.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული ტიპის საგნებში)
      */

    }
}


