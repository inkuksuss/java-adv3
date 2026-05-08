package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {


    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("KIM", 1, 85),
                new Student("aa", 1, 95),
                new Student("bM", 2, 15),
                new Student("c", 3, 100),
                new Student("d", 3, 90)
        );

        Map<Integer, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect = " + collect);

        Map<Integer, List<String>> collect1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("collect1 = " + collect1);

        Map<Integer, Long> collect2 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("collect2 = " + collect2);

        Map<Integer, Double> collect3 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.averagingInt(s -> s.getScore())));
        System.out.println("collect3 = " + collect3);

    }
}
