package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsSumming4 {

    public static void main(String[] args) {
        Long count1 = Stream.of(1, 2, 3)
                .collect(Collectors.counting());
        System.out.println("count1 = " + count1);

        long count2 = Stream.of(1, 2, 3).count();
        System.out.println("count2 = " + count2);

        Double average1 = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(i -> i));
        System.out.println("average1 = " + average1);

        double average2 = IntStream.rangeClosed(1, 3)
                .average()
                .getAsDouble();
        System.out.println("average2 = " + average2);

        IntSummaryStatistics statistics = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.summarizingInt(String::length));

        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMin());
    }
}
