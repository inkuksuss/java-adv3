package optional;

import java.util.Optional;

public class OptCreationMain {

    public static void main(String[] args) {
        String nonNull = "Hello Opt";
        Optional<String> opt1 = Optional.of(nonNull);
        System.out.println("opt1 = " + opt1);

        Optional<String> opt2 = Optional.ofNullable("Hello");
        System.out.println("opt2 = " + opt2);
    }
}
