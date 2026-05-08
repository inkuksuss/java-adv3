package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsBasic1 {

    public static void main(String[] args) {
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());
        System.out.println("list = " + list);

        List<Integer> collect = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("collect = " + collect);

        Set<Integer> set = Stream.of(1, 2, 2, 3, 3)
                .collect(Collectors.toSet());
        System.out.println("set = " + set);

        TreeSet<Integer> treeset = Stream.of(1, 2, 3, 4, 4)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeset = " + treeset);

    }
}
