package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsMinMax4 {

    public static void main(String[] args) {
        Integer max1 = Stream.of(1, 2, 3, 4)
                .collect(Collectors.maxBy(Integer::compare))
                .get();
        System.out.println("max1 = " + max1);

        Integer max2 = Stream.of(1, 2, 3, 4)
                .max(Integer::compare).get();
        System.out.println("max2 = " + max2);

        int max3 = IntStream.range(1, 4)
                .max().getAsInt();
        System.out.println("max3 = " + max3);
    }
}
