package optional;

import java.util.Optional;

public class OptionalStartM3 {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> empty = Optional.empty();

        System.out.println("=== if present ===");
        optValue.ifPresent(v -> System.out.println("v = " + v));
        empty.ifPresent(v -> System.out.println("v = " + v));

        System.out.println("=== if presentOfElse ===");
        optValue.ifPresentOrElse(v -> System.out.println("v = " + v),
                () -> System.out.println("No value present"));
        empty.ifPresentOrElse(v -> System.out.println("v = " + v),
                () -> System.out.println("No value present"));

        System.out.println("=== map ===");
        Optional<Integer> i = optValue.map(String::length);
        System.out.println("i = " + i);
        Optional<Integer> i1 = empty.map(String::length);
        System.out.println("i1 = " + i1);

        System.out.println("=== flat map ===");
        Optional<Optional<String>> s1 = optValue.map(s -> Optional.of(s));
        System.out.println("s1 = " + s1);
        Optional<String> s2 = s1.flatMap(s -> s);
        System.out.println("s2 = " + s2);

        System.out.println("===filter===");
        Optional<String> v1 = optValue.filter(s -> s.length() > 3);
        Optional<String> v2 = empty.filter(s -> s.length() > 3);
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        System.out.println("=== stream ===");
        optValue.stream().forEach(s -> System.out.println("opt s = " + s));
        empty.stream().forEach(s -> System.out.println("empty s = " + s));
    }
}