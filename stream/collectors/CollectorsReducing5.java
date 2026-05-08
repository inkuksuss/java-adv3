package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsReducing5 {

    public static void main(String[] args) {
        List<String> names = List.of("a", "b", "c");

        String joined = names.stream()
                .collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2))
                .get();
        System.out.println("joined = " + joined);

        String joined2 = names.stream().reduce((s1, s2) -> s1 + ", " + s2)
                .get();
        System.out.println("joined2 = " + joined2);

        String joined3 = names.stream().collect(Collectors.joining(", "));
        System.out.println("joined3 = " + joined3);

        String join = String.join(",", "a", "b", "c", "d");
        System.out.println("join = " + join);
    }
}
