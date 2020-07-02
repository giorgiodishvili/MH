package ge.itvet;

import ge.itvet.services.ExamService;
import ge.itvet.services.StatisticService;
import ge.itvet.university.Subject;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
          ExamService examService = new ExamService();
          StatisticService statisticService = new StatisticService();
        Map<Subject.Type, Integer> typePointsMap = statisticService.sumOfPointsGroupBySubjectType();
        System.out.println("typePointsMap = " + typePointsMap);
          System.out.println(statisticService.sortStudents5() );
        System.out.println(statisticService.sortGroupByType());
//        System.out.println(   bitChange(17,3,Binary.ONE));
        /*
     X 1.ქულების გენერცია თითოეული გრუპის სტუდენტზე
     X 2.საგნის ტიპის მიხედვით ქულების ჯამის დაბრუნება
     3.დავალაგოთ ჯგუფები საგნების  ტიპის მიხედვით(სად უფრო მეტი საშუალო ქულაა)
     4.დავალაგოთ ჯგუფები საგნის მიხედვით(სად უფრო მეტი საშუალო ქულაა)
     X 5.დავალაგოთ სტუდენტები ქულების მიხედვით
     6.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგანში)
     7.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგნებში)*
     8.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული ტიპის საგნებში)
      */
        System.out.println("THE END");
    }

    private enum Binary {
        ZERO,
        ONE
    }

    public static int bitChange(int number, int position, Binary binary) {
        switch (binary) {
            case ONE -> {
                int bin = 1;
                bin = bin << position;
                number = number | bin;


            }
            case ZERO -> {
                int bin = 255; //yvela 1 rom yofiliyo....
                int temp = 1 << position;
                bin = bin ^ temp;
                number = number & bin;
            }
        }
        return number;
    }
}


