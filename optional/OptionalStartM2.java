package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartM2 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "One");
        map.put(2L, "Two");
    }

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(2L);
    }

    static void findAndPrint(Long id) {
        Optional<String> optName = findNameById(id);
        String name = optName.orElse("unknown");
        System.out.println("Name for ID " + id + ": " + name);
    }

    static Optional<String> findNameById(Long id) {
        String name = map.get(id);
        return Optional.ofNullable(name);
    }}
