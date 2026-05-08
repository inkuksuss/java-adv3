package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroup3 {

    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Avocado", "Banana");
        Map<Character, List<String>> collect = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("collect = " + collect);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("partitioned = " + partitioned);

    }
}
