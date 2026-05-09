package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartM1 {

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
        String name = findNameById(id);

        if (name != null) {
            System.out.println("Name for ID " + id + ": " + name);
        }
    }

    static String findNameById(Long id) {
         return map.get(id);
    }}
