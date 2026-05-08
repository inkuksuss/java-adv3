package stream.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMap2 {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toMap(name -> name, name -> name.length()));
        System.out.println("map1 = " + map1);

        Map<String, Integer> map2 = Stream.of("Java", "Java", "JPA")
                .collect(Collectors.toMap(name -> name, name -> name.length(), (oldV, newV) -> oldV + newV));
        System.out.println("map2 = " + map2);

        Map<String, Integer> map3 = Stream.of("Java", "Java", "JPA")
                .collect(Collectors.toMap(
                        name -> name,
                        String::length,
                        (oldV, newV) -> oldV + newV,
                        LinkedHashMap::new
                ));
        System.out.println("map3 = " + map3);
    }
}
