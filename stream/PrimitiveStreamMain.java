package stream;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(System.out::println);
        System.out.println("=====================");

        IntStream range1 = IntStream.range(1, 5);
        IntStream range2 = IntStream.rangeClosed(1, 5);
        range1.forEach(System.out::println);
        System.out.println("=====================");

        range2.forEach(System.out::println);
        System.out.println("=====================");

        double avg = IntStream.range(1, 6).average().getAsDouble();
        System.out.println("avg = " + avg);
        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum = " + sum);
        int max = IntStream.range(1, 6).max().getAsInt();
        System.out.println("max = " + max);
        int min = IntStream.range(1, 6).min().getAsInt();
        System.out.println("min = " + min);
        long cnt = IntStream.range(1, 6).count();
        System.out.println("cnt = " + cnt);
        System.out.println("=====================");

        IntSummaryStatistics statistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println("statistics = " + statistics.toString());
        System.out.println("=====================");

        LongStream longStream = IntStream.range(1, 5).asLongStream();
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();
        Stream<Integer> boxed = IntStream.range(1, 5).boxed();
        LongStream mappedToLong = IntStream.range(1, 5).mapToLong(i -> i * 10L);
        DoubleStream mappedToDouble = IntStream.range(1, 5).mapToDouble(i -> i * 1.0);
        Stream<String> stringStream = IntStream.range(1, 5).mapToObj(i -> "number: " + i);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        int IntegerToInt = integerStream.mapToInt(i -> i).sum();

    }
}
