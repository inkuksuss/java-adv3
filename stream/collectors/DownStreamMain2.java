package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {


    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("KIM", 1, 85),
                new Student("aa", 1, 95),
                new Student("bM", 2, 15),
                new Student("c", 3, 100),
                new Student("d", 3, 90)
        );

        Map<Integer, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect = " + collect);

        Map<Integer, Optional<Student>> collect1 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)));
        System.out.println("collect1 = " + collect1);


        Map<Integer, Optional<Student>> collect2 = students.stream().collect(Collectors.groupingBy(Student::getGrade,
                Collectors.maxBy((s1, s2) -> s1.getScore() - s2.getScore())));
        System.out.println("collect2 = " + collect2);
        Map<Integer, Optional<Student>> collect3 = students.stream().collect(Collectors.groupingBy(Student::getGrade,
                Collectors.maxBy(Comparator.comparingInt(Student::getScore))));
        System.out.println("collect3 = " + collect3);

        Map<Integer, String> collect4 = students
                .stream().collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                                opt -> opt.get().getName()
                        )));
        System.out.println("collect4 = " + collect4);

    }
}
